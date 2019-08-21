package it.piksel.censa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.piksel.censa.document.Customer;
import it.piksel.censa.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@RequestMapping(value = "/info", method = RequestMethod.GET)
	public Customer getCustomer(@RequestParam String jwt_userid) {
		return customerService.getCustomer(jwt_userid);
	}

	// il merge è da sistemare
	@RequestMapping(value = "/patch", method = RequestMethod.PATCH)
	public Customer patchCustomer(@RequestParam String jwt_userid, @RequestBody Customer customer) {
		return customerService.patchCustomer(jwt_userid, customer);
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public Customer updateCustomer(@RequestParam String jwt_userid, @RequestBody Customer customer) {
		return customerService.updateCustomer(jwt_userid, customer);
	}

}
