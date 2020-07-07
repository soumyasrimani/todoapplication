package com.javante.expense.demouser.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.javante.expense.demouser.entity.Address;
import com.javante.expense.demouser.entity.User;
import com.javante.expense.demouser.exception.UserException;

@Repository
@Transactional
public class UserRepository {

	@Autowired
	@Qualifier("mongoTemplate")
	private MongoTemplate template;

	public User updateUser(User user) {
		try {
			Address newAddress = null;
			Address address = user.getAddress();
			if (address.getId() == null) {
				newAddress = template.insert(address);
			} else
				newAddress = template.save(address);
			user.setAddress(newAddress);
			return template.save(user);
		} catch (Exception e) {
			throw new UserException(e.getMessage());
		}
	}

	public User addUser(User user) {
		try {

			Address address = template.insert(user.getAddress());
           
			user.setAddress(address);
			return template.insert(user);
		} catch (Exception e) {
			throw new UserException(e.getMessage());
		}
	}

}
