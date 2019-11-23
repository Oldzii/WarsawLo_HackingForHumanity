package com.example.demo.repositories;


import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.entities.SchoolEntity;

public interface SchoolRepository extends MongoRepository<SchoolEntity, String>{
	
	
}