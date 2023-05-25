package com.example.demo.controllers;

import java.util.HashSet;
import java.util.Set;

import org.apache.coyote.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.helper.UserFoundException;
import com.example.demo.models.Role;
import com.example.demo.models.User;
import com.example.demo.models.UserRole;
import com.example.demo.services.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin("*") //isska mtlb angular ke port nd isske port mei issue nai aayega,cz dono ke ports alag hai;* mtlb saare host allow kr diye
public class UserController {
	//yaha saare end pts honge humare[website mei]
	//creating user
	@Autowired
	private UserService userService;
	/*@Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;*/
			
	//for angular
	//create user
	@PostMapping("/")
	public User createUser(@RequestBody User user) throws Exception {
		//encoding password with bcryptpasswordencoder
        //user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));
		Set<UserRole> roles=new HashSet<>();
		Role r=new Role();
		r.setRoleId(2);	
		r.setRname("NORMAL");
		UserRole userRole=new UserRole();
		userRole.setRole(r);
		userRole.setUser(user);
		roles.add(userRole);
		return this.userService.createUser(user, roles);
	}
		
	//fetching user
	@GetMapping("/{username}")
	public User getUser(@PathVariable("username") String username) {
		return this.userService.getUser(username);
	}
		
	//deleting user
	@DeleteMapping("/{uid}")
	public void delUser(@PathVariable("uid") int uid) {
		this.userService.delUser(uid);
	}
		
	//update api
	
	@ExceptionHandler(UserFoundException.class)
    public ResponseEntity<?> exceptionHandler(UserFoundException ex) {
        return ResponseEntity.ok(ex.getMessage());
    }
}