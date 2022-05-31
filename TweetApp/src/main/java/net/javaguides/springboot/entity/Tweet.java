package net.javaguides.springboot.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tweet" ,schema="tweetAppSchema")
public class Tweet {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long tweetId;
	
	@Column(name = "tweet_name")
	private String tweetName;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	@Column(name = "date_created")
	private String createdDate;
	
	@Column(name="likes")
	private int likes;
	
	@OneToMany(cascade= CascadeType.ALL)
	private List<Replies> replies;
	

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	public List<Replies> getReplies() {
		return replies;
	}

	public void setReplies(List<Replies> replies) {
		this.replies = replies;
	}

	public Tweet(long tweetId, String tweetName, User user, String createdDate,int likes) {
		super();
		this.tweetId = tweetId;
		this.tweetName = tweetName;
		this.user = user;
		this.createdDate = createdDate;
		this.likes = likes;
	}

	public Tweet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getTweetId() {
		return tweetId;
	}

	public void setTweetId(long tweetId) {
		this.tweetId = tweetId;
	}

	public String getTweetName() {
		return tweetName;
	}

	public void setTweetName(String tweetName) {
		this.tweetName = tweetName;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	
}
