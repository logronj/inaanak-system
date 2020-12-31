package com.logronj.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.logronj.models.FormDetails;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String hello(@ModelAttribute("formDetails") FormDetails formDetails) {
	
		return "home";
	}
	
	@RequestMapping("/submit")
	public String submit(@Valid @ModelAttribute("formDetails") FormDetails formDetails, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			for(ObjectError error : bindingResult.getAllErrors())
				System.out.println(error.getDefaultMessage()+ " "+error.getObjectName());
			
			return "home";
		}
		return "submit";
	}
	
}
