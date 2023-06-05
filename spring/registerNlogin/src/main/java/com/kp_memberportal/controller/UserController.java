package com.kp_memberportal.controller;

import java.util.HashSet;
import java.util.Set;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.kp_memberportal.entities.Role;
import com.kp_memberportal.entities.User;
import com.kp_memberportal.entities.UserRole;
import com.kp_memberportal.helper.UserNotFoundException;
import com.kp_memberportal.helper.UserFoundException;
import com.kp_memberportal.service.UserService;


@RestController
@RequestMapping("/user")

public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	//creating user
	@PostMapping("/")
	public User createUser(@RequestBody User user) throws Exception {
		
		//encoding password with bcryptpasswordencoder
		user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));
		
		Set<UserRole> roles = new HashSet<>();
		
		Role role = new Role();
		role.setRoleId(45L);
		role.setRoleName("NORMAL");
		
		UserRole userRole = new UserRole();
		userRole.setUser(user);
		userRole.setRole(role);
		roles.add(userRole);
		return this.userService.createUser(user,roles );
		
	}
	
	@GetMapping("/{email}")
	public User getUser(@PathVariable("email") String email) {
		return this.userService.getUser(email);
	}
	
	/*@GetMapping("/{userId}")
	public User getUserById(@PathVariable("userId") Long userId) {
		return this.userService.getUserById(userId);
	}*/
	//delete the user by id
	@DeleteMapping("/{userId}")
	public void deleteUser(@PathVariable("userId") Long userId) {
		this.userService.deleteUser(userId);
	}
	
	
	@ExceptionHandler(UserFoundException.class)
    public ResponseEntity<?> exceptionHandler(UserFoundException ex) {
        return ResponseEntity.ok(ex.getMessage());
    }
}
