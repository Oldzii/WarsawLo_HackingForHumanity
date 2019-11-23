package com.example.demo.repositories;


import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.entities.Mock;

public interface SchoolRepository extends MongoRepository<Mock, String>{
	
	
}