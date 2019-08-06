package it.piksel.censa.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import it.piksel.censa.customer.entity.Customer;
import it.piksel.censa.customer.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@RequestMapping(value = "/customers", method = RequestMethod.GET)
	public List<Customer> getAllCustomers() {
		return customerService.getAllCustomer();
	}

	@RequestMapping(value = "/customers/{id}", method = RequestMethod.GET)
	public Customer getCustomer(@PathVariable String id) {
		return customerService.getCustomer(id);
	}

	@RequestMapping(value = "/customers", method = RequestMethod.POST)
	public void addCustomer(@RequestBody Customer customer) {
		customerService.addCustomer(customer);
	}

	@RequestMapping(value = "/customers/{id}", method = RequestMethod.PUT)
	public void updateCustomer(@RequestBody Customer customer, @PathVariable String id) {
		customerService.updateCustomer(id, customer);
	}

	@RequestMapping(value = "/customers/{id}", method = RequestMethod.DELETE)
	public void deleteCustomer(@PathVariable String id) {
		customerService.deleteCustomer(id);
	}

}
