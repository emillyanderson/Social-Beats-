package com.example.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Following {
	
	@Id
	@GeneratedValue
	private long followingId;
	
    @Column
    private String username;
    
    @Column
    private String follower_id;

    //@ManyToOne(targetEntity = "following")
   // private Users user;
    
    public Following(){
    	
    }
    
    public String getUsername() {
    	return username;
    }
    
    public void setUsername(String s) {
    	username = s;
    }
    
    public long getFollowingID() {
    	return followingId;
    }
    
    public void setFollowingID(long id) {
    	followingId = id;
    }
    
    public String getFollowerID() {
    	return follower_id;
    }
    
    public void setFollowerID(String s) {
    	follower_id = s;
    }
}
