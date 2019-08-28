package it.piksel.censa.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.mongodb.repository.MongoRepository;

import it.piksel.censa.document.ShippingAddress;

public interface AddressRepository extends MongoRepository<ShippingAddress, String>, AddressRepositoryCustom {

	@Override
	@CacheEvict("address")
	void deleteById(String id);

	@Override
	@Cacheable("address")
	// @CacheEvict(value = "address", allEntries = true)
	List<ShippingAddress> findAll();

	// New
	@Cacheable("address")
	List<ShippingAddress> findByCustomerId(String customerId);

	@Override
	@Cacheable("address")
	Optional<ShippingAddress> findById(String id);

	@Cacheable("address")
	List<ShippingAddress> findByIdAndCustomerId(String id, String customerId);

	@SuppressWarnings("unchecked")
	@Override
	@CachePut("address")
	ShippingAddress save(ShippingAddress address);

}
