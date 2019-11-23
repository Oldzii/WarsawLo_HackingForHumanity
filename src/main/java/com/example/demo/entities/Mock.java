package com.example.demo.entities;

import java.util.ArrayList;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "mock")
public class Mock {

	
	private String name;
	private String cityDistrict;
	private boolean foreignExchanges;
	private double recruitmentPointsLevel;
	private ArrayList<String> classProfiles;
	private int numOfLanguages;
	
	
	
}
