package com.kp_memberportal.helper;

@SuppressWarnings("serial")
public class UserNotFoundException extends Exception{
	
	public UserNotFoundException() {
		super("User with this username is not found in DB !!! Please try with valid credentials");
	}
	
	public UserNotFoundException(String msg) {
		super(msg);
	}
}
