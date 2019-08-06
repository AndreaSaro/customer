package it.piksel.censa.customer.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.piksel.censa.customer.entity.Customer;
import it.piksel.censa.customer.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	public List<Customer> getAllCustomer() {
		List<Customer> customers = new ArrayList<Customer>();
		customerRepository.findAll().forEach(customers::add);
		return customers;
	}

	public Customer getCustomer(String id) {
		return customerRepository.findById(id).get();
	}

	public void addCustomer(Customer customer) {
		//validation
		//if ok save
		customerRepository.save(customer);
	}

	public void updateCustomer(String id, Customer customer) {
		customerRepository.save(customer);
	}

	public void deleteCustomer(String id) {
		customerRepository.deleteById(id);
	}

}
