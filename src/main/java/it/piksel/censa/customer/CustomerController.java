package it.piksel.censa.customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@RequestMapping(value = "/customers", method = RequestMethod.GET)
	public List<Customer> getAllCustomers() {
		return customerService.getAllCustomer();
	}

	@RequestMapping(value = "/customer/{id}", method = RequestMethod.GET)
	public Customer getCustomer(@PathVariable String id) {
		return customerService.getCustomer(id);
	}

	@RequestMapping(value = "/add-customer", method = RequestMethod.POST)
	public void addCustomer(@RequestBody Customer customer) {
		customerService.addCustomer(customer);
	}

	@RequestMapping(value = "/update-customer/{id}", method = RequestMethod.PUT)
	public void updateCustomer(@RequestBody Customer customer, @PathVariable String id) {
		customerService.updateCustomer(id, customer);
	}

	@RequestMapping(value = "/delete-customer/{id}", method = RequestMethod.DELETE)
	public void deleteCustomer(@PathVariable String id) {
		customerService.deleteCustomer(id);
	}

}
