package it.piksel.censa.repository;

import org.springframework.cache.annotation.CachePut;

import it.piksel.censa.document.Customer;

public interface CustomerRepositoryCustom{

	@CachePut("customer")
	void patch(Customer customer);
    
}
