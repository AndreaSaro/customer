package it.piksel.censa.customer;

import java.util.List;
import java.util.Optional;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.mongodb.repository.MongoRepository;

import it.piksel.censa.document.Customer;

public interface CustomerRepository extends MongoRepository<Customer,String>{

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
    Customer save(Customer customer);

    @Override
    @CacheEvict("customer")
    void deleteById(String id);
    
}
