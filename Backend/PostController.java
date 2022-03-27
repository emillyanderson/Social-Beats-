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
public class PostController {

	@Autowired
	PostRepository postRepository;
	
	@Autowired
	LikeRepository likeRepository;
	
	//@Autowired 
	//UserRepository userRepository;
		
	@GetMapping(value="/getAllPost")
	public List<Post> getAllPost() {
		return postRepository.findAll();
		
	}
	
	@PostMapping(value="/getUserPosts")
	public List<Post> getUserPosts(@RequestBody String username) {
		
		System.out.println(username);
		
		List<Post> allPosts = postRepository.findAll();
		List<Post> userPost = new ArrayList<>();
		
		for(Post post : allPosts) {
			if(post.getUser().equalsIgnoreCase(username)) {
				userPost.add(post);
			}
		}
		return userPost;
		
	}
	
	@PostMapping(value="/savePost")
	public String savePost(@RequestBody Post post) {
		if (postRepository.save(post) != null) {
			return "Success!";
		}
		
		return "not successful!";
	}
	
	@GetMapping(value="/getUserFeed")
	public List<Post> getUserFeed(@RequestParam List<String> following) {
		List<Post> feed = new ArrayList<>();
		List<Post> allPosts = postRepository.findAll();
		for(Post post : allPosts) {
			for(String user : following) {
				if(post.getUser() != null) {
					if(post.getUser().equalsIgnoreCase(user)) {
						feed.add(post);
					}
				}				
			}
		}
		for(int i=0; i<feed.size(); i++) {
			if(i != feed.size()) {
				if(feed.get(i) == feed.get(i+1)) {
					feed.remove(i);
				}
			}
			
		}
		return feed;
		
	}
	
	@GetMapping(value="/getNumLikes")
	public int getNumLikes(@RequestParam int postId){
		List<Likes> likes = likeRepository.findAll();
		int numLikes = 0;
		for(Likes n: likes) {
			if(n.getPostId() == postId) {
				numLikes++;
			}
		}
		return numLikes;
	}
	
	@PostMapping(value="/modifyLike")
	public String modifyLike(@RequestParam int postId, @RequestParam String username) {

		List<Likes> likes = likeRepository.findAll();
		List<Likes> postLikes = new ArrayList<Likes>();
		boolean usernameFound= false;
		Likes fromUser = null;
		for(Likes like : likes) {
			if(like.getPostId() == postId){
				postLikes.add(like);
			}
		}
		for(Likes like : postLikes) {
			if(like.getUsername().equalsIgnoreCase(username)) {
				usernameFound = true;
				fromUser = like;
				break;
			}
		}
		
		List<Post> posts = postRepository.findAll();
		Post targetPost = new Post();
		for(Post p: posts) {
			if(p.getId() == postId) {
				targetPost.setId(postId);
				targetPost.setSong(p.getSong());
				targetPost.setArtist(p.getArtist());
				targetPost.setReview(p.getReview());
				targetPost.setUser(p.getUser());
				targetPost.setNumLikes(postLikes.size());
				break;
				
			}
		}
		
		if(usernameFound) {
			likeRepository.delete(fromUser);
<<<<<<< HEAD
			//if((int)likeRepository.count()!= 0) {
				post.setNumLikes((int)likeRepository.count());
			//}
=======
			targetPost.setNumLikes(targetPost.getNumLikes()-1);
			postRepository.save(targetPost);
>>>>>>> ea5cfd820219d973a836cca76504ba043b183107
			return "User successfully removed from this post's likes";
		}
		else {
			Likes newLike = new Likes();
			newLike.setPostId(postId);
			newLike.setUsername(username);
			likeRepository.save(newLike);
<<<<<<< HEAD
			//if((int)likeRepository.count()!= 0) {
				post.setNumLikes((int)likeRepository.count());

			//}
=======
			targetPost.setNumLikes(targetPost.getNumLikes()+1);
			postRepository.save(targetPost);
>>>>>>> ea5cfd820219d973a836cca76504ba043b183107
			return "User successfully added to this post's likes";
		}
	}
	
	@GetMapping(value="/getPost")
	public Post getPost(@RequestParam int postId) {
		List<Post> posts = postRepository.findAll();
		for(Post p: posts) {
			if(p.getId() == postId) {
				return p;
			}
		}
		return new Post();
	}
}