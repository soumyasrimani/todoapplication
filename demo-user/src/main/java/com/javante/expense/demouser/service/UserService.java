package com.javante.expense.demouser.service;

import com.javante.expense.demouser.entity.User;

public interface UserService {
	
	public User addUser(User user);
	
	public User updateUser(User user);
	
	public User getUserByEmail(String email);
	
	public User getUserById(String id);
	
	public User deleteUser(String id);

}
