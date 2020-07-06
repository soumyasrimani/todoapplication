package com.javante.app.todo.model;

import org.springframework.stereotype.Component;

@Component
public class Home {
	
	private String message;
	
	public Home() {}
	
	public Home(String message)
	{
		this.message =message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
	

}
