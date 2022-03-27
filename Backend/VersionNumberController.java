package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersionNumberController {
	
	@Autowired
	VersionNumberRepository versionNumberRepository;
	
	@GetMapping(value="/getVersionNumber")
	public VersionNumber getVersionNumber() {
		List<VersionNumber> versions = versionNumberRepository.findAll();
		/*
		if(versions.size() > 1) {
			return "Error: Too Many Version Numbers Stored";
		}
		if(versions.size() == 0) {
			return "Error: There are no stored version numbers";
		}
		return versions.get(0).getVersionNumber();
		*/
		VersionNumber number = null;
		for(VersionNumber i : versions) {
			number = i;
		}
		return number;
	}
	
}
