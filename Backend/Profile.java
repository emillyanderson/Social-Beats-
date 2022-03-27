package com.example.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Profile {
	
	@Id
	@GeneratedValue
	private int profileId;
	
	@Column
	private String username;
	
	@Column
	private String fullName;
	
	@Column
	private String genre;
	
	@Column
	private String favoriteSong;
	
	@Column
	private String bio;
	
	@Column
	private int followers;
	
	@Column
	private int following;
	
	// need setters and getters
	public int getId() {
		return profileId;
	}
	
	public void setId(int id) {
		profileId = id;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String newUsername) {
		username = newUsername;
	}
	
	public String getFullName() {
		return fullName;
	}
	
	public void setFullName(String newFullName) {
		fullName = newFullName;
	}
	
	public String getGenre() {
		return genre;
	}
	
	public void setGenre(String newGenre) {
		genre = newGenre;
	}
	
	public String getFavoriteSong() {
		return favoriteSong;
	}
	
	public void setFavoriteSong(String newFavoriteSong) {
		favoriteSong = newFavoriteSong;
	}
	
	public String getBio() {
		return bio;
	}
	
	public void setBio(String newBio) {
		bio = newBio;
	}
	
	public int getFollowers() {
		return followers;
	}
	
	public void setFollowers(int newFollowers) {
		followers = newFollowers;
	}
	
	public int getFollowing() {
		return following;
	}
	
	public void setFollowing(int newFollowing) {
		following = newFollowing;
	}
	
	

}
