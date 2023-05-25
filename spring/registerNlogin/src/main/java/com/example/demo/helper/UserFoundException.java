package com.example.demo.helper;

public class UserFoundException extends Exception{
	
	public UserFoundException() {
        super("User with this Username already exists! Try with another username!");
    }

    public UserFoundException(String mssg){
        super(mssg);
    }
}