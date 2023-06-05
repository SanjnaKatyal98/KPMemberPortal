package com.kp_memberportal.service.impl;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.kp_memberportal.service.EmailSenderService;

@Service
public class EmailSenderServiceImpl implements EmailSenderService{

	
	private final JavaMailSender mailSender;
	
	public EmailSenderServiceImpl(JavaMailSender mailSender) {
		this.mailSender=mailSender;
	}
	@Override
	public void sendEmail(String to, String subject, String message) {
		// TODO Auto-generated method stub
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setFrom("kpmemberportal123@gmail.com");
		simpleMailMessage.setTo(to);
		simpleMailMessage.setSubject(subject);
		simpleMailMessage.setText(message);
		
		this.mailSender.send(simpleMailMessage);
	}

}