package com.example.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.models.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	/*
	  DB mei sari cheeze pohunchane ke liye we use repo
	  repo ki sari functionality lene ke liye we extend this interface
	  generic type hota hai-1.kiss type ki entity,2.ooski id kiss type ki hai
	  user ko save,del etc krne ke liye isske obj se ho jayenge
	  user se related DB operations honge 
	  DB se related functions obj se honge
	*/
	public User findByUsername(String username);
}