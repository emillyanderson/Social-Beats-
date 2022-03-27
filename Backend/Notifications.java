package com.example.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Notifications{
	
	@Id
	@GeneratedValue
	private int id;
	
	@Column
	private String username;
	
	@Column
	private String notificationText;
	
	public Notifications() {
		
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int x) {
		id = x;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String s) {
		username = s;
	}
	
	public String getNotification() {
		return notificationText;
	}
	
	public void setNotification(String s) {
		notificationText = s;
	}
	
}