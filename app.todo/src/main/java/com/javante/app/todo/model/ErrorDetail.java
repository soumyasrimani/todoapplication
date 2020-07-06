package com.javante.app.todo.model;

import java.io.Serializable;
import java.util.Date;

public class ErrorDetail implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1468740541376746051L;
	private Date date;
	private String message;
	private String status;
	
	public ErrorDetail()
	{}
	
	public ErrorDetail(Date date, String message, String status) {
		super();
		this.date = date;
		this.message = message;
		this.status = status;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	

}
