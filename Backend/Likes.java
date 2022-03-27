package com.example.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;

@Entity
public class Likes {
	@Id
	@GeneratedValue
	private int id;
	
	@Column
	private String username;
	
	@Column
	private int postId;
	
	public int getLikeId() {
		return id;
	}
	
	public void setLikeId(int num) {
		id = num;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String user) {
		username = user;
	}
	
	public int getPostId() {
		return postId;
	}
	
	public void setPostId(int id) {
		postId = id;
	}
}
