package net.javaguides.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.entity.Replies;
import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.repository.RepliesRepository;

@RestController
@RequestMapping("/api/replies")
public class RepliesController {
	@Autowired
	private RepliesRepository repliesRepository;
	// get user by id
		@GetMapping("/{id}")
		public Replies getRepliesByTweetId(@PathVariable (value = "id") long tweetId) {
			return this.repliesRepository.findById(tweetId)
					.orElseThrow(() -> new ResourceNotFoundException("Tweet not found with id :" + tweetId));
		}
		// create user
		@PostMapping
		public Replies createReplies(@RequestBody Replies replies) {
			return this.repliesRepository.save(replies);
		}
}
