package com.example.demo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.JoinColumn;

@Entity
public class Followers {
	
	@Id
	@GeneratedValue
	private int id;
	
    @Column
    private String user_id;
    
    @Column
    private String following_id;
    
	public String getuser_id() {
		return user_id;
	}
	
	public void setuser_id(String user_id) {
		this.user_id = user_id;
	}
	
	public String getfollowing_id() {
		return following_id;
	}
	
	public void setfollowing_id(String following_id) {
		this.following_id = following_id;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
    
//    
//    @ManyToMany
//    @JoinTable(
//    	name="Users",
//    	joinColumns = {@JoinColumn(name = "userId")},
//    	inverseJoinColumns = {@JoinColumn(name = "userId")})
//    private List<Users> friends;
//
//    @ManyToMany
//    @JoinTable(name="Users",
//     joinColumns=@JoinColumn(name="userId"),
//     inverseJoinColumns=@JoinColumn(name="userId"))
//    private List<Users> friendOf;
	
  //  @ManyToOne(targetEntity = )
  //  private Users user;

    

}
