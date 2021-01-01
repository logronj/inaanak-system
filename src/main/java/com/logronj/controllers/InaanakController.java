package com.logronj.controllers;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.logronj.models.EmailDto;
import com.logronj.repository.InaanakRepository;
import com.logronj.services.EmailService;

@RestController
public class InaanakController {
	
	Logger logger = Logger.getLogger(InaanakController.class);
	
	@Autowired
	public InaanakRepository nameRepository;
	
	@Autowired
	public EmailService emailService;
	
	@ResponseBody
	@GetMapping(value = "/getInaanak/{firstName}")
	public String getInaanakByFirstName(@PathVariable String firstName) {
		logger.info("fn: " + firstName);
		try {
			return nameRepository.getInaanakByFirstName(firstName);
		}catch(Exception e) {
			return "error";
		}
	}
	
	@ResponseBody
	@PostMapping("/sendEmail")
	public String sendEmail() {
		EmailDto emailDto = new EmailDto();
		try{
			emailService.sendEmail(emailDto);
			return "success";
		}catch(Exception e) {
			return "error: "+e.getMessage();
		}
		
	}

}
