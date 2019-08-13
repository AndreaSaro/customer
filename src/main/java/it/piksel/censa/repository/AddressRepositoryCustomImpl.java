package it.piksel.censa.repository;

import java.lang.reflect.Field;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import it.piksel.censa.document.Address;
import it.piksel.censa.document.Customer;

@Component
public class AddressRepositoryCustomImpl implements AddressRepositoryCustom{

	private final MongoTemplate mongoTemplate;
	private static final Logger logger = LoggerFactory.getLogger(AddressRepositoryCustomImpl.class);

	@Autowired
	public AddressRepositoryCustomImpl(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}
	
	@Override
	public void patch(Address address) {
		try {
			Query query = new Query(Criteria.where("id").is(address.getId()));
			Update update = new Update();
			Class<?> clazz = address.getClass();
			for (Field field : clazz.getDeclaredFields()) {
				field.setAccessible(true);
				Object fieldValue = field.get(address);
				if (fieldValue != null) {
					update.set(field.getName(), fieldValue);
				}
			}
			mongoTemplate.updateFirst(query, update, address.getClass());
		} catch (Exception e) {
			logger.error("errore nell'update del customer", e);
		}
	}

	
    
}
