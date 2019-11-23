package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.services.FormService;

@RestController
@CrossOrigin(value = "*")
@RequestMapping(path = "/api/form")
public class FormController {

	
	@Autowired
	private FormService formService;
	
//	@RequestMapping(method = RequestMethod.GET, path = "/")
//	public String 
	
	
	
	
}
