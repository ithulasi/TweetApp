package net.javaguides.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.javaguides.springboot.entity.Tweet;

@Repository
public interface TweetRepository extends JpaRepository<Tweet, Long>{

}
