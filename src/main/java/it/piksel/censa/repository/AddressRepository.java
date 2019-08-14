package it.piksel.censa.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.mongodb.repository.MongoRepository;

import it.piksel.censa.document.Address;

public interface AddressRepository extends MongoRepository<Address,String>, AddressRepositoryCustom{

	@Override
	@Cacheable("address")
	Optional<Address> findById(String id);

	@Override
	@Cacheable("address")
	//@CacheEvict(value = "address", allEntries = true)
	List<Address> findAll();

	@SuppressWarnings("unchecked")
	@Override
	@CachePut("address")
	Address save(Address address);

    @Override
    @CacheEvict("address")
    void deleteById(String id);
    
    //New
    @Cacheable("address")
    List<Address> findByCustomerId(String customerId);
    
    @Cacheable("address")
    List<Address> findByIdAndCustomerId(String id, String customerId);
    
}
