package com.example.demo.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.models.User;
import com.example.demo.repos.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	//user ko by usrname load krayega
	@Autowired
    private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = this.userRepository.findByUsername(username);
        if (user == null) {
            System.out.println("User not found!");
            throw new UsernameNotFoundException("No user found!");
        }
        return user;
	}
}