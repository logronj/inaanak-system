package com.logronj.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import com.logronj.models.EmailDto;

@Service
public class EmailServiceImpl implements EmailService {

	@Autowired
	private JavaMailSender javaMailSender;
	
	@Override
	public void sendEmail(EmailDto emailDto) {
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setTo("testfirstname1.testlastname1@gmail.com");
		simpleMailMessage.setSubject("Inaanak System");
		simpleMailMessage.setText("Test only from inaanak system");
		
		javaMailSender.send(simpleMailMessage);
	}
	
}
