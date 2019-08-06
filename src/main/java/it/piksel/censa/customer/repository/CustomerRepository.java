package it.piksel.censa.customer.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.CrudRepository;

import it.piksel.censa.customer.entity.Customer;

public interface CustomerRepository extends CrudRepository<Customer,String>{

	@Override
	@Cacheable("customer")
	Optional<Customer> findById(String id);

	@Override
    @Cacheable("customer")
    @CacheEvict(value = "customer", allEntries = true)
    List<Customer> findAll();

    @SuppressWarnings("unchecked")
	@Override
    @CachePut("customer")
    Customer save(Customer entity);

    @Override
    @CacheEvict("customer")
    void deleteById(String name);
    
}
