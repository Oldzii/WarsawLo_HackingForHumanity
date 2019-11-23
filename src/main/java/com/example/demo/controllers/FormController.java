package com.example.demo.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.services.FormService;

@RestController
@CrossOrigin(value = "*")
@RequestMapping(path = "/api/form")
public class FormController {

	
	@Autowired
	private FormService formService;
	

	@RequestMapping(method = RequestMethod.GET, path = "/question")
	public String getQuestions() {
		return formService.getQuestions();
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/answers")
	public ArrayList<String> getAnswers(@RequestBody ArrayList<ArrayList<Integer>> newList) {
		
		return formService.getProfiles(newList);
		
	}
	
	
	
	
	
}
