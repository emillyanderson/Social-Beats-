package com.example.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;

@Entity
public class VersionNumber {
	
	@Id
	@GeneratedValue
	private int id;
	
	@Column
	private String versionNumber;
	
	public VersionNumber() {
		
	}
	
	public void setVersionNumber(String s) {
		versionNumber = s;
	}
	
	public String getVersionNumber() {
		return versionNumber;
	}
	
	public void setId(int x) {
		id = x;
	}
	
	public int getId() {
		return id;
	}
}
