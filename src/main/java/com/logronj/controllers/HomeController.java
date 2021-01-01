package com.logronj.controllers;

import javax.validation.Valid;

import org.jboss.logging.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.logronj.models.FormDetails;

@Controller
public class HomeController {
	
	Logger logger = Logger.getLogger(HomeController.class);
	
	@RequestMapping("/")
	public String hello(@ModelAttribute("formDetails") FormDetails formDetails) {
	
		return "home";
	}
	
	@PostMapping("/submit")
	public String submit(@Valid @ModelAttribute("formDetails") FormDetails formDetails, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			for(ObjectError error : bindingResult.getAllErrors())
				logger.info(error.getDefaultMessage()+ " "+error.getObjectName());
			
			return "home";
		}
		return "submit";
	}
	
}
