package com.example.demo.services;

import java.util.Set;
import com.example.demo.models.User;
import com.example.demo.models.UserRole;

public interface UserService {
	//DB mei cheeze save krne ke liye
	//loose coupling ki yaha
	//creating user
	//kitne roles mille user ko
			
	//creating user
	public User createUser(User user,Set<UserRole> userRoles) throws Exception;
			
	//get user by username
	public User getUser(String username);
			
	//delete user by id
	public void delUser(int uid);
}