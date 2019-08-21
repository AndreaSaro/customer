package it.piksel.censa.repository;

import org.springframework.cache.annotation.CachePut;

import it.piksel.censa.document.Address;

public interface AddressRepositoryCustom {

	@CachePut("address")
	void patch(Address address);

}
