package com.kp_memberportal.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kp_memberportal.entities.User;

public interface UserRepository extends JpaRepository<User,Long> {

	public User findByUsername(String username);
	
	public Optional<User> findById(Long userId);
}
