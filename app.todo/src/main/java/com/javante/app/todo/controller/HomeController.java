package com.javante.app.todo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javante.app.todo.model.Home;

@RestController
@RequestMapping("/home")
@CrossOrigin(origins="http://localhost:4200")
public class HomeController {
	@Autowired
	Home home;
	
	@GetMapping("/hello")
	public Home greeting()
	{
		home = new Home("Welcome Rest Api Controller");
		return home;
	}

	@GetMapping("/hello/{name}")
	public Home greetingVariable(@PathVariable("name") String name)
	{
		home = new Home("Welcome Rest Api Controller by " + name);
		return home;
	}

	
}
