package it.piksel.censa.customer;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.piksel.censa.document.Customer;
import it.piksel.censa.error.DataIsNotValidException;

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

	public void addCustomer(Customer customer) throws DataIsNotValidException {
		try {
			customerRepository.save(customer);
		} catch (ConstraintViolationException e) {
		    throw new DataIsNotValidException("Data is not valid " + e.getMessage());
		}
		
	}

	public void updateCustomer(String id, Customer customer) {
		customerRepository.save(customer);
	}

	public void deleteCustomer(String id) {
		customerRepository.deleteById(id);
	}

}
