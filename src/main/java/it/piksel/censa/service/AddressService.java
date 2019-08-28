package it.piksel.censa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.piksel.censa.document.ShippingAddress;
import it.piksel.censa.repository.AddressRepository;

@Service
public class AddressService {

	@Autowired
	private AddressRepository addressRepository;

	public ShippingAddress addAddress(String customerId, ShippingAddress address) {
		address.setCustomerId(customerId);
		return addressRepository.save(address);
	}

	public void deleteAddress(String userId, String id) {
		List<ShippingAddress> addresses = addressRepository.findByIdAndCustomerId(id, userId);
		if (addresses != null && !addresses.isEmpty()) {
			addressRepository.deleteById(id);
		}
	}

	public ShippingAddress getAddress(String customerId, String id) {
		List<ShippingAddress> addresses = addressRepository.findByIdAndCustomerId(id, customerId);
		if (addresses != null && !addresses.isEmpty()) {
			return addresses.get(0);
		}
		return null;
	}

	public List<ShippingAddress> getAllAddresses(String customerId) {
		return addressRepository.findByCustomerId(customerId);
	}

	public ShippingAddress patchAddress(String customerId, String id, ShippingAddress address) {
		address.setId(id);
		addressRepository.patch(address);
		Optional<ShippingAddress> optionalAddress = addressRepository.findById(id);
		return optionalAddress.get();
	}

	public ShippingAddress updateAddress(String customerId, String id, ShippingAddress address) {
		address.setId(id);
		address.setCustomerId(customerId);
		return addressRepository.save(address);
	}

}
