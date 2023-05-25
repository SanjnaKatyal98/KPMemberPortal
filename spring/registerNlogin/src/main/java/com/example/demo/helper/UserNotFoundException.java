package com.example.demo.helper;

public class UserNotFoundException extends Exception{
	
	public UserNotFoundException() {
        super("User with this username not found in database!");
    }
    
	public UserNotFoundException(String mssg) {
        super(mssg);
    }
}