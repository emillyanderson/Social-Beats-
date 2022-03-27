package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FollowingController {
	
	@Autowired
	FollowingRepository followingRepository;
	
	@GetMapping(value="/getAllFollowing")
	public List<Following> getAllFollowing(){
		return followingRepository.findAll();
	}
}
