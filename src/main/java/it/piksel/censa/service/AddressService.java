package it.piksel.censa.service;

import java.lang.invoke.MethodHandles;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.piksel.censa.document.Address;
import it.piksel.censa.repository.AddressRepository;

@Service
public class AddressService {

	private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	@Autowired
	private AddressRepository addressRepository;

	public Address addAddress(String customerId, Address address) {
		address.setCustomerId(customerId);
		return addressRepository.save(address);
	}

	public void deleteAddress(String userId, String id) {
		List<Address> addresses = addressRepository.findByIdAndCustomerId(id, userId);
		if (addresses != null && !addresses.isEmpty()) {
			addressRepository.deleteById(id);
		}
	}

	public Address getAddress(String customerId, String id) {
		List<Address> addresses = addressRepository.findByIdAndCustomerId(id, customerId);
		if (addresses != null && !addresses.isEmpty()) {
			return addresses.get(0);
		}
		return null;
	}

	public List<Address> getAllAddresses(String customerId) {
		return addressRepository.findByCustomerId(customerId);
	}

	public Address patchAddress(String customerId, String id, Address address) {
		address.setId(id);
		addressRepository.patch(address);
		Optional<Address> optionalAddress = addressRepository.findById(id);
		return optionalAddress.get();
	}

	public Address updateAddress(String customerId, String id, Address address) {
		address.setId(id);
		address.setCustomerId(customerId);
		return addressRepository.save(address);
	}

}
