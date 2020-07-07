package com.javante.expense.demouser.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javante.expense.demouser.entity.User;
import com.javante.expense.demouser.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository repo;
	
	@Override
	public User addUser(User user) {
		
		return repo.addUser(user);
	}

	@Override
	public User updateUser(User user) {
		return repo.updateUser(user);
	}

	@Override
	public User getUserByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User deleteUser(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
