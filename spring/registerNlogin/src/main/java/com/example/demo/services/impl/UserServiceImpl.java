package com.example.demo.services.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.User;
import com.example.demo.models.UserRole;
import com.example.demo.repos.RoleRepository;
import com.example.demo.repos.UserRepository;
import com.example.demo.services.UserService;

@Service
public class UserServiceImpl implements UserService{
	//user and role ko save krenge
	@Autowired
	UserRepository userRepo;
	@Autowired
	RoleRepository roleRepo;
	
	//creating user
	@Override
	public User createUser(User user, Set<UserRole> userRoles) throws Exception {
		//ek ek krke role ko nikalenge then save krenge
		User local=this.userRepo.findByUsername(user.getUsername());
		//check krenge ki user jo aa raha already DB mei hai ki nai
		if(local!=null)
		  {
		   System.out.print("user already exists!");
		   throw new Exception("user already exists in database!");
		  }
		else
		  {
		   //create user
		   for(UserRole ur:userRoles) {
			   roleRepo.save(ur.getRole());//sirf roles ko save kia
		   }
		   user.getUserRoles().addAll(userRoles);//assign krdiye saare roles to user,then save krenge
		   local=this.userRepo.save(user);
		  }
		return local;
	}

	//getting user by username
	@Override
	public User getUser(String username) {
		return this.userRepo.findByUsername(username);
		//kuch data ni hoga toh null millega
	}
		
	//delete user by id
	@Override
	public void delUser(int uid) {
		this.userRepo.deleteById(uid);
	}
}