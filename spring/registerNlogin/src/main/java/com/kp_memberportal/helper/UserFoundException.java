package com.kp_memberportal.helper;

@SuppressWarnings("serial")
public class UserFoundException extends Exception{
	
	public UserFoundException() {
		super("User is already present in database !!!");
	}
	
	public UserFoundException(String msg) {
		super(msg);
	}
}
