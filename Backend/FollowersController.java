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
public class FollowersController {

	@Autowired
	FollowersRepository followersRepository;
		
	@GetMapping(value="/getAllFollowers")
	public List<Followers> getAllFollowers() {
		return followersRepository.findAll();
	}
	
	@PostMapping(value="/saveFollowers")
	public String saveFollowers(@RequestBody Followers followers) {
		if (followersRepository.save(followers) != null) {
			return "Success!";
		}
		
		return "not successful!";
	}
	
	
	//possible error
	@PostMapping(value="/saveFollower")
	public String saveFollower() {
		Followers follows = new Followers();
		//follows.setUserId(user);
		//follows.setFollowingId(follow);
		if(followersRepository.save(follows) != null) {
			return "Success!";			
		}		
		return "try again";
		
	}
	
	@GetMapping(value="/getFollowing")
	public List<String> getFollowing(@RequestParam String user) {
		List<Followers> followers = followersRepository.findAll();
		List<Followers> userFollowing = new ArrayList<>();
		
		for(Followers follower : followers) {
			if(follower.getuser_id().equalsIgnoreCase(user)) {
				userFollowing.add(follower);
			}
		}
		List<String> following = new ArrayList<>();
		for(int i=0; i<userFollowing.size(); i++) {
			following.add(userFollowing.get(i).getfollowing_id());
		}

		return following;
		
	}
	
	@GetMapping(value="/getIfFollowing")
	public boolean getIfFollowing(@RequestParam String user1, @RequestParam String user2) {
		boolean isFollowing = false;
		List<String> followingList = getFollowing(user1);
		for(String s: followingList) {
			if(s.equalsIgnoreCase(user2)) {
				isFollowing = true;
			}
		}
		return isFollowing;
	}
	
}
