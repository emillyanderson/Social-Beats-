package com.example.demo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Users {
	
	@Id
	@GeneratedValue
	private int userId;
	
	@Column
	private String username;
	
	@Column
	private String fullName;
	
	@Column
	private String email;
	
	@Column
	private String password;
	
	@Column
	private String bio;
	
	@Column
	private String image;
	
	// need setters and getters
	public int getId() {
		return userId;
	}
	
	public void setId(int id) {
		userId = id;
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
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String newEmail) {
		email = newEmail;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String newPassword) {
		password = newPassword;
	}
	
	public String getBio() {
		return bio;
	}
	
	public void setBio(String newBio) {
		bio = newBio;
	}
	
	public String getImage() {
		return image;
	}
	
	public void setImage(String newImage) {
		image = newImage;
	}
	
//    @JoinTable(
//    	name="Followers",
//    	joinColumns = {@JoinColumn(name = "userId", referencedColumnName = "userId", nullable = false)},
//    	inverseJoinColumns = {@JoinColumn(name = "following_id", referencedColumnName = "userId", nullable = false)})
//    @ManyToMany(mappedBy="Followers")
//    private List<Users> following;
//    
//    public List<Users> getFollowing() {
//    	return following;
//    }
//    
//    public void setFollowing(List<Users> list) {
//    	following = list;
//    }
//
//    @ManyToMany
//    @JoinTable(name="Users",
//     joinColumns=@JoinColumn(name="userId"),
//     inverseJoinColumns=@JoinColumn(name="userId"))
//    private List<Users> friendOf;
	
//	@OneToMany(mappedBy="userId")
//    private Following following;
	
	

}
