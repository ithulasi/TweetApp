package net.javaguides.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.entity.Tweet;
import net.javaguides.springboot.entity.User;
import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.repository.TweetRepository;

@RestController
@RequestMapping("/api/tweets")
public class TweetController {
	@Autowired
	private TweetRepository tweetRepository;

	// get all users
	@GetMapping
	public List<Tweet> getAllTweets() {
		return this.tweetRepository.findAll();
	}

	// get user by id
	@GetMapping("/{id}")
	public Tweet getTweetById(@PathVariable (value = "id") long tweetId) {
		return this.tweetRepository.findById(tweetId)
				.orElseThrow(() -> new ResourceNotFoundException("Tweet not found with id :" + tweetId));
	}

	// create user
	@PostMapping
	public Tweet createTweet(@RequestBody Tweet tweet) {
		return this.tweetRepository.save(tweet);
	}
	
	// update user
	@PutMapping("/{id}")
	public Tweet updateTweet(@RequestBody Tweet tweet, @PathVariable ("id") long tweetId) {
		 Tweet existingTweet = this.tweetRepository.findById(tweetId)				 
			.orElseThrow(() -> new ResourceNotFoundException("Tweet not found with id :" + tweetId));
		 User existingUser = new User();		 
		 existingUser.setFirstName(tweet.getUser().getFirstName());
		 existingUser.setLastName(tweet.getUser().getLastName());
		 existingUser.setEmail(tweet.getUser().getEmail());
		 existingTweet.setUser(existingUser);
		 existingTweet.setTweetName(tweet.getTweetName());
		 existingTweet.setCreatedDate(tweet.getCreatedDate());
		 existingTweet.setLikes(tweet.getLikes());
		 return this.tweetRepository.save(existingTweet);
	}
	// update user
		@PutMapping("/like/{id}")
		public Tweet updateLike(@RequestBody Tweet tweet, @PathVariable ("id") long tweetId) {
			 Tweet existingTweet = this.tweetRepository.findById(tweetId)				 
				.orElseThrow(() -> new ResourceNotFoundException("Tweet not found with id :" + tweetId));
			 User existingUser = new User();		 
			 existingUser.setFirstName(tweet.getUser().getFirstName());
			 existingUser.setLastName(tweet.getUser().getLastName());
			 existingUser.setEmail(tweet.getUser().getEmail());
			 existingTweet.setUser(existingUser);
			 existingTweet.setTweetName(tweet.getTweetName());
			 existingTweet.setCreatedDate(tweet.getCreatedDate());
			 existingTweet.setLikes(tweet.getLikes()+1);
			 return this.tweetRepository.save(existingTweet);
		}
	
	// delete user by id
	@DeleteMapping("/{id}")
	public ResponseEntity<User> deleteUser(@PathVariable ("id") long tweetId){
		Tweet existingTweet = this.tweetRepository.findById(tweetId)
					.orElseThrow(() -> new ResourceNotFoundException("Tweet not found with id :" + tweetId));
		 this.tweetRepository.delete(existingTweet);
		 return ResponseEntity.ok().build();
	}
	
}
