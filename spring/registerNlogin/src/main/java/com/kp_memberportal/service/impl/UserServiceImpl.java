package com.kp_memberportal.service.impl;

import java.util.Set;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kp_memberportal.entities.User;
import com.kp_memberportal.entities.UserRole;
import com.kp_memberportal.helper.UserNotFoundException;
import com.kp_memberportal.helper.UserFoundException;
import com.kp_memberportal.repo.RoleRepository;
import com.kp_memberportal.repo.UserRepository;
import com.kp_memberportal.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	//creating user
	@Override
	public User createUser(User user, Set<UserRole> userRoles) throws Exception {
		// TODO Auto-generated method stub
		
		User local = this.userRepository.findByUsername(user.getUsername());
		if(local != null) {
			System.out.println("User is already there !");
			throw new UserFoundException();
		}else {
			//create user
			for(UserRole ur:userRoles) {
				roleRepository.save(ur.getRole());
			}
			
			user.getUserRoles().addAll(userRoles);
			local = this.userRepository.save(user);
		}
				
		return local;
	}

	//getting user by email
	@Override
	public User getUser(String username) {
		// TODO Auto-generated method stub
		return this.userRepository.findByUsername(username);
	}
	
	//getting user by id
		/*@Override
		public Optional<User> getUserById(Long userId) {
			// TODO Auto-generated method stub
			return this.userRepository.findById(userId);
		}*/
	
	//deleting user by userId
	@Override
	public void deleteUser(Long userId) {
		// TODO Auto-generated method stub
		this.userRepository.deleteById(userId);
	}
	
	
	

}
