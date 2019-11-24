package com.example.demo.repositories;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.entities.Mock;

public interface SchoolRepository extends MongoRepository<Mock, String>{
	
	ArrayList<Mock> findAllMockByCityDistrictAndForeignExchangesAndRecruitmentPointsLevel(String cityAddress, boolean isExchangeAvailable, int recruitmentPointsLevel);
//	Mock findMockByForeignExchanges(boolean isExchangeAvaiable);
}