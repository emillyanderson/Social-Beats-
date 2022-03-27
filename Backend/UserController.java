package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@Autowired
	UserRepository userRepository;
	
	@GetMapping(value="/getAllUsers")
	public List<Users> getAllUsers() {
		return userRepository.findAll();
		
	}
	
	@GetMapping(value="/getUser")
	@ResponseBody
	public Users getUser(@RequestParam String username) {
		List<Users> userList = userRepository.findAll();
		Users user = new Users();
		for(Users n: userList) {
			if(n.getUsername().equalsIgnoreCase(username)) {
				user = n;
			}
		}
		return user;
	}
	
	@PostMapping(value="/saveUser")
	public String saveUser(@RequestBody Users user) {
		if (userRepository.save(user) != null) {
			return "saved";
		}
		
		return "not saved";
	}
	
	@PostMapping(value="/updateUser")
	public String updateUser(@RequestBody Users user) {
		
		List<Users> userList = getAllUsers();
		Users currentUser = new Users();
		boolean success = false;
		
		for(Users n: userList) {
			if(user.getUsername().equalsIgnoreCase(n.getUsername())) {
				currentUser = n;
				success = true;
			}
		}
		
		if(user.getEmail() != null && success) {
			currentUser.setEmail(user.getEmail());
		}
		if(user.getPassword() != null && success) {
			currentUser.setPassword(user.getPassword());
		}
		
		if(success) {
			return "Values successfully updated";
		}
		else {
			return "Error: no user was found with this username";
		}
		
	}
	
	
	

}
