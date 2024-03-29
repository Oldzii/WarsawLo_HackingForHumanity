package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Mock;
import com.example.demo.repositories.SchoolRepository;

@Service
public class SchoolService {

	@Autowired
	private SchoolRepository schoolRepository;
	
	
	public List<Mock> fetchAll() {
		return schoolRepository.findAll();
	}
	
	
	
}
