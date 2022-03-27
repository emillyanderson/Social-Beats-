package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Post {
	
	@Id
	@GeneratedValue
	private int postId;
	
	@Column
	private String song;
	
	@Column
	private String artist;
	
	@Column
	private String review;
	
	@Column 
	private String user;
	
	@Column 
	private int numLikes;
	
	//@ElementCollection
	//@CollectionTable(name = "likes")
	//@Column
	//private List<Users> likes;
	
	public String getUser() {
		return user;
	}
	
	public void setUser(String newUser) {
		user = newUser;
	}
	

	public int getId() {
		return postId;
	}
	
	public void setId(int id) {
		postId = id;
	}
	
	public String getSong() {
		return song;
	}
	
	public void setSong(String newSong) {
		song = newSong;
	}
	
	public String getArtist() {
		return artist;
	}
	
	public void setArtist(String newArtist) {
		artist = newArtist;
	}
	
	public String getReview() {
		return review;
	}
	
	public void setReview(String newReview) {
		review = newReview;
	}
	
	public void setNumLikes(int x) {
		numLikes = x;
	}
	
	public int getNumLikes() {
		return numLikes;
	}
	
	
	//public List getLikes() {
	//	return likes;
	//}
	
	//public void setLikes(List<Users> n) {
	//	likes = n;
	//}
	
	
	

}
