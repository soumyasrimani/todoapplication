package com.javante.app.todo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
@Entity
@XmlRootElement
@Table(name="todo")
public class Todo {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String description;
	private Date targetDate ;
	private Status status;
	private String userName;
	
	public Todo()
	{}
	
	public Todo(int id, String description, Date targetDate, Status status, String userName) {
		this.id = id;
		this.description = description;
		this.targetDate = targetDate;
		this.status = status;
		this.userName = userName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getTargetDate() {
		return targetDate;
	}
	public void setTargetDate(Date targetDate) {
		this.targetDate = targetDate;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "Todo [id=" + id + ", description=" + description + ", targetDate=" + targetDate + ", status=" + status
				+ ", userName=" + userName + "]";
	}
	
	
	
}