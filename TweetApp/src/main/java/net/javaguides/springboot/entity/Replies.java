package net.javaguides.springboot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "replies" ,schema="tweetAppSchema")
public class Replies {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long replyId;
	@Column(name = "replytext")
	private String replytext;
	
	@ManyToOne
	@JoinColumn(name = "tweetId")
	private Tweet tweet;

	public long getReplyId() {
		return replyId;
	}

	public void setReplyId(long replyId) {
		this.replyId = replyId;
	}

	public String getReplytext() {
		return replytext;
	}

	public void setReplytext(String replytext) {
		this.replytext = replytext;
	}

	public Tweet getTweet() {
		return tweet;
	}

	public void setTweet(Tweet tweet) {
		this.tweet = tweet;
	}

	public Replies() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Replies(long replyId, String replytext) {
		super();
		this.replyId = replyId;
		this.replytext = replytext;
	}
}
