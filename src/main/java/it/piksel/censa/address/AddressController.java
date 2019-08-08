package it.piksel.censa.address;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressController {

	@Autowired
	private AddressService addressService;

	@RequestMapping(value = "/addresses", method = RequestMethod.GET)
	public List<Address> getAllAddresses() {
		return addressService.getAllAddresses();
	}

	@RequestMapping(value = "/address/{id}", method = RequestMethod.GET)
	public Address getAddress(@PathVariable String id) {
		return addressService.getAddress(id);
	}

	@RequestMapping(value = "/add-address", method = RequestMethod.POST)
	public void addAddress(@RequestBody Address address) {
		addressService.addAddress(address);
	}

	@RequestMapping(value = "/update-address/{id}", method = RequestMethod.PUT)
	public void updateAddress(@RequestBody Address address, @PathVariable String id) {
		addressService.updateAddress(id, address);
	}

	@RequestMapping(value = "/address/{id}", method = RequestMethod.DELETE)
	public void deleteAddress(@PathVariable String id) {
		addressService.deleteAddress(id);
	}

}
