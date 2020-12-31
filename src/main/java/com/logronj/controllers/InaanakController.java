package com.logronj.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.logronj.repository.InaanakRepository;

@RestController
public class InaanakController {
	
	@Autowired
	public InaanakRepository nameRepository;
	
	@ResponseBody
	@GetMapping(value = "/getInaanak/{firstName}")
	public String getInaanakByFirstName(@PathVariable String firstName) {
		System.out.println("fn: " + firstName);
		return nameRepository.getInaanakByFirstName(firstName);
	}

}
