package com.kp_memberportal.service;

public interface EmailSenderService {

	void sendEmail(String to , String subject, String message);
}