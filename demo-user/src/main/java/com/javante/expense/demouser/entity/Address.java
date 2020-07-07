package com.javante.expense.demouser.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Address {

	@Id
	private String id;
	private String city;
	private long pincode;

	public Address() {
	}

	public Address(String city, long pincode) {
		this.city = city;
		this.pincode = pincode;
	}

	public String getId() {
		return id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public long getPincode() {
		return pincode;
	}

	public void setPincode(long pincode) {
		this.pincode = pincode;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", city=" + city + ", pincode=" + pincode + "]";
	}

}
