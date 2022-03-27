package com.example.demo;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class ProfileController {


	@Autowired
	ProfileRepository profileRepository;
	
	@GetMapping(value="/getAllProfile")
	public List<Profile> getAllProfile() {
		return profileRepository.findAll();
		
	}
	
	@GetMapping(value="/getProfile")
	public Profile getProfile(@RequestParam String username) {

		List<Profile> profiles = profileRepository.findAll();
		
		for(Profile profile : profiles) {
			if(profile.getUsername().equalsIgnoreCase(username)) {
				return profile;
			}

		}

		return null;
	}

	@PostMapping(value="/getProfile")
	public Profile getProfile(@RequestBody Profile username) {

		List<Profile> profiles = profileRepository.findAll();
		
		for(Profile profile : profiles) {
			if(profile.getUsername().toString().equalsIgnoreCase(username.getUsername().toString())) {
				return profile;
			}

		}
		return null;

		
	}
	
	@GetMapping(value="/searchProfile")
	public List<Profile> searchProfile(@RequestParam String searchedUser) {
		List<Profile> profiles = profileRepository.findAll();
		List<Profile> results = new ArrayList<>();
		for(Profile profile : profiles) {
			if(profile.getUsername().contains(searchedUser) || profile.getUsername().equalsIgnoreCase(searchedUser)) {
				results.add(profile);
			}
		}

		return results;
	}
		
		
	
	@PostMapping(value="/saveProfile")
	public String saveProfile(@RequestBody Profile profile) {
		if (profileRepository.save(profile) != null) {
			return "saved";
		}
		
		return "not saved";
	}
}