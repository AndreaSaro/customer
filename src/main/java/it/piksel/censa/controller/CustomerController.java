package it.piksel.censa.controller;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

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

	@RequestMapping(value = "/patch", method = RequestMethod.PATCH)
	public Customer patchCustomer(@RequestParam String jwt_userid, @RequestBody Customer customer) {
		return customerService.patchCustomer(jwt_userid, customer);
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public Customer updateCustomer(@RequestParam String jwt_userid, @RequestBody Customer customer) {
		return customerService.updateCustomer(jwt_userid, customer);
	}

	// invocabili solo da api gateway perchè è lui che genera il JWT
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public Customer registerCustomer(@RequestBody Customer customer) {
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			byte[] encodedPassword = digest.digest(customer.getPassword().getBytes(StandardCharsets.UTF_8));
			customer.setPassword(new String(encodedPassword));
			return customerService.saveCustomer(customer);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public Customer loginCustomer(@RequestBody Customer customer) {
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			byte[] encodedPassword = digest.digest(customer.getPassword().getBytes(StandardCharsets.UTF_8));
			return customerService.loginCustomer(customer.getUsername(), new String(encodedPassword));
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	// posso cancellare solo me stesso, il delete può essere invocato anche dal
	// microservizio stesso perchè tanto è il client che deve cancellare il jwt
	// il logout infatti non esiste, è il client a farlo
	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public void deleteCustomerUser(@RequestParam String jwt_userid) {
		customerService.delete(jwt_userid);
	}

}
