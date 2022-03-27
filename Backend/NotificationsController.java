package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotificationsController {
	
	@Autowired
	NotificationsRepository notificationsRepository;
	
	@GetMapping(value="/getNotifications")
	public List<Notifications> getNotifications(@RequestParam String username){
		List<Notifications> notifications = notificationsRepository.findAll();
		List<Notifications> userNotifications = new ArrayList<>();
		
		for(Notifications n: notifications) {
			if(n.getUsername().equalsIgnoreCase(username)) {
				userNotifications.add(n);
			}
		}
		
		return userNotifications;
	}
	
	@PostMapping(value="/saveNotification")
	public String saveNotification(@RequestBody Notifications notifications) {
		if(notificationsRepository.save(notifications) != null) {
			return "Success";
		}
		return "Unsuccessful";
	}
}
