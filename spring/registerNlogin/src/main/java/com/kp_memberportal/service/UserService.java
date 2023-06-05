package com.kp_memberportal.service;

import java.util.Set;

import com.kp_memberportal.entities.User;
import com.kp_memberportal.entities.UserRole;
import com.kp_memberportal.helper.UserNotFoundException;

public interface UserService {
	
	//creating user
	public User createUser(User user, Set<UserRole> userRoles) throws Exception;

	//get user by email
	public User getUser(String username);   
	
	//get user by id
	//public User getUserById(Long userId);   
	
	//delete user by id
	public void deleteUser(Long userId);

	
}
