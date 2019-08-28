package it.piksel.censa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.piksel.censa.document.ShippingAddress;
import it.piksel.censa.service.AddressService;
import it.piksel.censa.validation.OnController;

@RestController
public class AddressController {

	@Autowired
	private AddressService addressService;

	@RequestMapping(value = "/address/add", method = RequestMethod.POST)
	public ShippingAddress addAddress(@RequestParam String jwt_userid, @Validated(OnController.class) @RequestBody ShippingAddress address) {
		return addressService.addAddress(jwt_userid, address);
	}

	@RequestMapping(value = "/address/delete/{id}", method = RequestMethod.DELETE)
	public void deleteAddress(@RequestParam String jwt_userid, @PathVariable String id) {
		addressService.deleteAddress(jwt_userid, id);
	}

	@RequestMapping(value = "/address/{id}", method = RequestMethod.GET)
	public ShippingAddress getAddress(@RequestParam String jwt_userid, @PathVariable String id) {
		return addressService.getAddress(jwt_userid, id);
	}

	@RequestMapping(value = "/addresses", method = RequestMethod.GET)
	public List<ShippingAddress> getAllAddresses(@RequestParam String jwt_userid) {
		return addressService.getAllAddresses(jwt_userid);
	}

//	// il merge è da sistemare
//	@RequestMapping(value = "/address/patch/{id}", method = RequestMethod.PATCH)
//	public ShippingAddress patchAddress(@RequestParam String jwt_userid, @RequestBody ShippingAddress address, @PathVariable String id) {
//		return addressService.patchAddress(jwt_userid, id, address);
//	}

	@RequestMapping(value = "/address/update/{id}", method = RequestMethod.PUT)
	public ShippingAddress updateAddress(@RequestParam String jwt_userid, @Validated @RequestBody ShippingAddress address, @PathVariable String id) {
		return addressService.updateAddress(jwt_userid, id, address);
	}

}
