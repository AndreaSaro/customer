package it.piksel.censa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.piksel.censa.document.Address;
import it.piksel.censa.service.AddressService;

@RestController
public class AddressController {

	@Autowired
	private AddressService addressService;

	@RequestMapping(value = "/addresses", method = RequestMethod.GET)
	public List<Address> getAllAddresses(@RequestParam String jwt_userid) {
		return addressService.getAllAddresses(jwt_userid);
	}
	
	@RequestMapping(value = "/address/{id}", method = RequestMethod.GET)
	public Address getAddress(@RequestParam String jwt_userid, @PathVariable String id) {
		return addressService.getAddress(jwt_userid, id);
	}
	
	@RequestMapping(value = "/address/add", method = RequestMethod.POST)
	public Address addAddress(@RequestParam String jwt_userid, @RequestBody Address address) {
		return addressService.addAddress(jwt_userid, address);
	}

	@RequestMapping(value = "/address/update/{id}", method = RequestMethod.PUT)
	public Address updateAddress(@RequestParam String jwt_userid, @RequestBody Address address, @PathVariable String id) {
		return addressService.updateAddress(jwt_userid, id, address);
	}
	
	//il merge è da sistemare
	@RequestMapping(value = "/address/patch/{id}", method = RequestMethod.PATCH)
	public Address patchAddress(@RequestParam String jwt_userid, @RequestBody Address address, @PathVariable String id) {
		return addressService.patchAddress(jwt_userid, id, address);
	}

	@RequestMapping(value = "/address/delete/{id}", method = RequestMethod.DELETE)
	public void deleteAddress(@RequestParam String jwt_userid, @PathVariable String id) {
		addressService.deleteAddress(jwt_userid, id);
	}

}
