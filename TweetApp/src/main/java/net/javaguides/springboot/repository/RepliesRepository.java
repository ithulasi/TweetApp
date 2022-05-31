package net.javaguides.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.javaguides.springboot.entity.Replies;
@Repository
public interface RepliesRepository extends JpaRepository<Replies, Long>{

}
