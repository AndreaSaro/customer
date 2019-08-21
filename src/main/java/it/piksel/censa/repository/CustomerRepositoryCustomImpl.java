package it.piksel.censa.repository;

import java.lang.invoke.MethodHandles;
import java.lang.reflect.Field;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import it.piksel.censa.document.Customer;

@Component
public class CustomerRepositoryCustomImpl implements CustomerRepositoryCustom {

	private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
	private final MongoTemplate mongoTemplate;

	@Autowired
	public CustomerRepositoryCustomImpl(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

	@Override
	public void patch(Customer customer) {
		try {
			Query query = new Query(Criteria.where("id").is(customer.getId()));
			Update update = new Update();
			Class<?> clazz = customer.getClass();
			for (Field field : clazz.getDeclaredFields()) {
				field.setAccessible(true);
				Object fieldValue = field.get(customer);
				if (fieldValue != null) {
					update.set(field.getName(), fieldValue);
				}
			}
			mongoTemplate.updateFirst(query, update, Customer.class);
		} catch (Exception e) {
			logger.error("errore nell'update del customer", e);
		}
	}

}
