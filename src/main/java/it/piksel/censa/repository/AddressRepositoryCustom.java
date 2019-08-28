package it.piksel.censa.repository;

import org.springframework.cache.annotation.CachePut;

import it.piksel.censa.document.ShippingAddress;

public interface AddressRepositoryCustom {

	@CachePut("address")
	void patch(ShippingAddress address);

}
