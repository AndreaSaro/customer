package it.piksel.censa.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.piksel.censa.document.Customer;
import it.piksel.censa.repository.CustomerRepository;

@Service
public class CustomerService {

	private static final Logger logger = LoggerFactory.getLogger(CustomerService.class);

	@Autowired
	private CustomerRepository customerRepository;

	public Customer getCustomer(String userId) {
		Optional<Customer> optionalCustomer = customerRepository.findById(userId);
		return optionalCustomer.isPresent() ? optionalCustomer.get() : null;
	}

	public Customer patchCustomer(String userId, Customer customer) {
		customer.setId(userId);
		customerRepository.patch(customer);
		Optional<Customer> optionalCustomer = customerRepository.findById(userId);
		return optionalCustomer.get();
	}

	public Customer updateCustomer(String userId, Customer customer) {
		customer.setId(userId);
		return customerRepository.save(customer);
	}

}
