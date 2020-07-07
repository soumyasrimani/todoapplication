package com.javante.expense.demouser.entity;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class User {

	@Id
	private String id;
	@NotNull(message="First Name Cannot be Null")
	private String firstName;
	@NotNull(message="Last Name Cannot be Null")
	private String lastName;
	@Email(message="Email format NOT correct")
	@NotNull(message="Email Cannot be Null")
	private String email;
	@NotNull(message="Mobile Number Cannot be Null")
	private long number;
	@DBRef
	private Address address;
	@NotNull(message="User Type Cannot be Null")
	private UserType type;

	public User() {
	}

	public User(String firstName, String lastName, String email, long number, Address address, UserType type) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.number = number;
		this.address = address;
		this.type = type;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getNumber() {
		return number;
	}

	public void setNumber(long number) {
		this.number = number;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public UserType getType() {
		return type;
	}

	public void setType(UserType type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", number=" + number + ", address=" + address + ", type=" + type + "]";
	}

}
