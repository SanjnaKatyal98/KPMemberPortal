package com.lcwd.care.service.exceptions;

public class ResourceNotFoundException extends RuntimeException {
	
	 public ResourceNotFoundException() {
	        super("Resource not found on server !!");
	    }

	    public ResourceNotFoundException(String message) {
	        super(message);
	    }

}
