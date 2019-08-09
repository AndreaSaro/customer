package it.piksel.censa.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.piksel.censa.document.Address;
import it.piksel.censa.repository.AddressRepository;
import it.piksel.censa.utils.ObjectUtils;

@Service
public class AddressService {

	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	ObjectUtils objectUtils;
	
	private static final Logger logger = LoggerFactory.getLogger(AddressService.class);

	public List<Address> getAllAddresses(String customerId) {
		return addressRepository.findByCustomerId(customerId);
	}

	public Address getAddress(String customerId, String id) {
		List<Address> addresses = addressRepository.findByIdAndCustomerId(id, customerId);
		if(addresses!=null && !addresses.isEmpty()) {
			return addresses.get(0);
		}
		return null;
	}

	public Address addAddress(String customerId, Address address) {
		address.setCustomerId(customerId);
		return addressRepository.save(address);
	}

	public Address updateAddress(String customerId, String id, Address address) {
		address.setId(id);
		address.setCustomerId(customerId);
		return addressRepository.save(address);
	}
	
	public Address patchAddress(String customerId, String id, Address address) {
		List<Address> addresses = addressRepository.findByIdAndCustomerId(id, customerId);
		if(addresses!=null && !addresses.isEmpty()) {
			try {
				Address combinedAddress = objectUtils.merge(addresses.get(0), address);
				return addressRepository.save(combinedAddress);
			} catch (Exception e) {
				logger.error("dovrei rilanciare una mia eccezione" ,e);
				return null;
			}
		}
		return null;
	}

	public void deleteAddress(String userId, String id) {
		List<Address> addresses = addressRepository.findByIdAndCustomerId(id, userId);
		if(addresses!=null && !addresses.isEmpty()) {
			addressRepository.deleteById(id);
		}
	}

}
