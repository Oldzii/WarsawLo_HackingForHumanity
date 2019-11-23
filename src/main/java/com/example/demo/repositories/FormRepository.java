package com.example.demo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.entities.FormEntity;

public interface FormRepository extends MongoRepository<FormEntity, String>{
	
	
	
}