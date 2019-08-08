package it.piksel.censa.address;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

	@Autowired
	private AddressRepository addressRepository;

	public List<Address> getAllAddresses() {
		List<Address> addresses = new ArrayList<Address>();
		addressRepository.findAll().forEach(addresses::add);
		return addresses;
	}

	public Address getAddress(String id) {
		return addressRepository.findById(id).get();
	}

	public Address addAddress(Address address) {
		return addressRepository.save(address);
	}

	public Address updateAddress(String id, Address address) {
		address.setId(id);
		return addressRepository.save(address);
	}

	public void deleteAddress(String id) {
		addressRepository.deleteById(id);
	}

}
