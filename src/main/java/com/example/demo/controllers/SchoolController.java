package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Mock;
import com.example.demo.services.SchoolService;


@RestController
@CrossOrigin(value = "*")
@RequestMapping(path = "/api/school")
public class SchoolController {

	@Autowired
	private SchoolService schoolService; 
	
	@RequestMapping(method = RequestMethod.GET, path = "/fetch")
	public List<Mock> fetchAll() {

		return schoolService.fetchAll();
	}
	
	
}
