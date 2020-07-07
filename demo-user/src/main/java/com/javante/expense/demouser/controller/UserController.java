package com.javante.expense.demouser.controller;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.javante.expense.demouser.entity.Address;
import com.javante.expense.demouser.entity.User;
import com.javante.expense.demouser.entity.UserType;
import com.javante.expense.demouser.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService service;
	
	@PostMapping(produces="application/json")
	public ResponseEntity<User> addUser(@RequestBody @Valid User user)
	{
		System.out.println(user);
		User addUser = service.addUser(user);
		
		URI uri = ServletUriComponentsBuilder
		.fromCurrentRequest().path("/{id}").buildAndExpand("id",addUser.getId()).toUri();
		
		HttpHeaders header = new HttpHeaders();
		header.set("location", uri.toString());		
		return new ResponseEntity<>(addUser,header,HttpStatus.CREATED);
	}
	
	@PutMapping(produces="application/json")
	public ResponseEntity<User> updateUser(User user)
	{
		User addUser = service.updateUser(user);
		
		URI uri = ServletUriComponentsBuilder
		.fromCurrentRequest().path("/{id}").buildAndExpand("id",addUser.getId()).toUri();
		
		HttpHeaders header = new HttpHeaders();
		header.set("location", uri.toString());
		
		return new ResponseEntity<>(addUser,header,HttpStatus.OK);
	}
	
	@GetMapping()
	public ResponseEntity<User> getUser()
	{
		
		Address address = new Address("pune",411057l);
		User user = new User("soumya","srimani","ssrimani@yahoo.com",9433530785l,address,UserType.USER);
		
		return new ResponseEntity<>(user,HttpStatus.OK);
	}
	
	
}
