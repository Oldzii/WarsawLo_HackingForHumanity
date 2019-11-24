package com.example.demo.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Mock;
import com.example.demo.repositories.SchoolRepository;
import com.example.demo.services.FormService;

@Service
public class FormService {
	
	@Autowired
	private SchoolRepository schoolRepository;

	public String getQuestions() {

		String mockString = "\"{\\\"questions\\\":[{\\\"id\\\":1,\\\"content\\\":\\\"Twoje ulubione przedmioty to?\\\",\\\"type\\\":\\\"poli\\\",\\\"answer\\\":[\\\"biologia\\\",\\\"chemia\\\",\\\"fizyka\\\",\\\"geografia\\\",\\\"historia\\\",\\\"informatyka\\\",\\\"j\\u0119zyk angielski\\\",\\\"j\\u0119zyk niemiecki\\\",\\\"j\\u0119zyk polski\\\",\\\"matematyka\\\",\\\"wiedza o spo\\u0142ecze\\u0144stwie\\\",\\\"wychowanie fizyczne\\\"]},{\\\"id\\\":2,\\\"content\\\":\\\"W jakim przedmiocie najlepiej si\\u0119 czujesz?\\\",\\\"type\\\":\\\"mono\\\",\\\"answer\\\":[\\\"biologia\\\",\\\"chemia\\\",\\\"fizyka\\\",\\\"geografia\\\",\\\"historia\\\",\\\"informatyka\\\",\\\"j\\u0119zyk angielski\\\",\\\"j\\u0119zyk niemiecki\\\",\\\"j\\u0119zyk polski\\\",\\\"matematyka\\\",\\\"wiedza o spo\\u0142ecze\\u0144stwie\\\",\\\"wychowanie fizyczne\\\"]},{\\\"id\\\":3,\\\"content\\\":\\\"Co robisz w czasie wolnym?\\\",\\\"type\\\":\\\"poli\\\",\\\"answer\\\":[\\\"Czytam ksi\\u0105\\u017cki\\\",\\\"Ucz\\u0119 si\\u0119 j\\u0119zyk\\u00f3w obcych\\\",\\\"Zajmuj\\u0119 si\\u0119 zwi\\u0119rz\\u0119tami\\\",\\\"Du\\u017co podr\\u00f3\\u017cuj\\u0119\\\",\\\"Tworz\\u0119 strony internetowe i aplikacje mobilne\\\",\\\"Rozwi\\u0105zuj\\u0119 zagadki logiczne\\\",\\\"Interesuj\\u0119 si\\u0119 sytuacj\\u0105 polityczn\\u0105 na \\u015bwiecie\\\",\\\"Gram na instrumencie muzycznym\\\",\\\"Rozwijam si\\u0119 artystycznie (\\u015bpiewam, gram w teatrze etc)\\\"]},{\\\"id\\\":4,\\\"content\\\":\\\"Czy lubisz uczy\\u0107 si\\u0119 j\\u0119zyk\\u00f3w obcych?\\\",\\\"type\\\":\\\"mono\\\",\\\"answer\\\":[\\\"Tak\\\",\\\"Nie\\\"]},{\\\"id\\\":5,\\\"content\\\":\\\"W jakiej dzielnicy chcia\\u0142by\\u015b ucz\\u0119szcza\\u0107 do szko\\u0142y?\\\",\\\"type\\\":\\\"poli\\\",\\\"answer\\\":[\\\"Bemowo\\\",\\\"Bia\\u0142o\\u0142\\u0119ka\\\",\\\"Bielany\\\",\\\"Mokot\\u00f3w\\\",\\\"Ochota\\\",\\\"Praga Po\\u0142udnie\\\",\\\"Praga P\\u00f3\\u0142noc\\\",\\\"Rembert\\u00f3w\\\",\\\"\\u015ar\\u00f3dmie\\u015bcie\\\",\\\"Targ\\u00f3wek\\\",\\\"Ursus\\\",\\\"Ursyn\\u00f3w\\\",\\\"Wawer\\\",\\\"Weso\\u0142a\\\",\\\"Wilan\\u00f3w\\\",\\\"W\\u0142ochy\\\",\\\"Wola\\\",\\\"\\u017boliborz\\\"]},{\\\"id\\\":6,\\\"content\\\":\\\"Czy planujesz wzi\\u0105\\u0107 udzia\\u0142 w wymianie zagranicznej\\\",\\\"type\\\":\\\"mono\\\",\\\"answer\\\":[\\\"Tak\\\",\\\"Nie\\\"]},{\\\"id\\\":7,\\\"content\\\":\\\"Jakiego oczekujesz wyniku z egzaminu ko\\u0144cowego?\\\",\\\"type\\\":\\\"mono\\\",\\\"answer\\\":[\\\"0 - 100\\\",\\\"101 - 125\\\",\\\"126 - 150\\\",\\\"151 - 175\\\",\\\"176 - 200\\\"]}]}\"";
		return mockString;
	}

	public ArrayList<String> getSchools(ArrayList<String> profiles, ArrayList<ArrayList<Integer>> answers){
		ArrayList<String> schoolsNames = new ArrayList<>();
//		answers.get(4);
		String cityAddress = "Wilanów";
		boolean isExchangeAvailable = false;
		int indexOfRecruitmentPointsRange = 2;
		//
		ArrayList<Mock> suitableMocks = schoolRepository.findAllMockByCityDistrictAndForeignExchangesAndRecruitmentPointsLevel(cityAddress, isExchangeAvailable, indexOfRecruitmentPointsRange);
		
		Iterator<Mock> mocksIterator = suitableMocks.iterator();
		
		// Traversing elements
		while(mocksIterator.hasNext()){
			schoolsNames.add(mocksIterator.next().getName());			
		}
		
		
		return schoolsNames;
	}
	
	//ready to finish or modify the method, check for all questions connected with the profiles
	public static ArrayList<String> getProfiles(ArrayList<Integer> firstQuestion){
		Map<String, Integer> profiles = new HashMap<>();
		ArrayList<String> outputString = new ArrayList<>();
		profiles.put("mat-inf", 0);
		profiles.put("humanistyczny", 0);
		profiles.put("biol-chem", 0);
		profiles.put("fiz-inf", 0);
		profiles.put("artystyczny", 0);
		profiles.put("geograficzny", 0);
		profiles.put("dziennikarski", 0);
		profiles.put("historyczny", 0);
//
//		"biologia",0
//		"chemia",
//		"fizyka",
//		"geografia",3
//		"historia",
//		"informatyka",
//		"jêzyk angielski",6
//		"jêzyk niemiecki",
//		"jêzyk polski",
//		"matematyka",9
//		"wiedza o spo³eczeñstwie",
//		"wychowanie fizyczne"
		// Exemplary
		if (firstQuestion.contains("9") || firstQuestion.contains("5")) {
			profiles.replace("mat-inf", 1);
		}

		if (firstQuestion.contains("4") || firstQuestion.contains("8")) {
			profiles.replace("humanistyczny", 1);
		}
		
		if(firstQuestion.contains("0") && firstQuestion.contains("1")) {
			profiles.replace("biol-chem", 1);
		}
		
		if(firstQuestion.contains("2") || firstQuestion.contains("5")) {
			profiles.replace("fiz-inf", 1);
		}
		
		if(firstQuestion.contains("4") || firstQuestion.contains("11")) {
			profiles.replace("artystyczny", 1);
		}
		
		if(firstQuestion.contains("3") || firstQuestion.contains("10")) {
			profiles.replace("geograficzny", 1);
		}
		
		if(firstQuestion.contains("6") || firstQuestion.contains("7") || firstQuestion.contains("8")) {
			profiles.replace("dziennikarski", 1);
		}
		
		if(firstQuestion.contains("4") || firstQuestion.contains("10")) {
			profiles.replace("historyczny", 1);
		}
		
		
		for (Map.Entry<String, Integer> item : profiles.entrySet()) {
		    String key = item.getKey();
		    int value = item.getValue();
		    if(value > 0) {
		    	outputString.add(key);
		    }
		}
		
		return outputString;
	}
	// control
	public ArrayList<String> getSchools(ArrayList<ArrayList<Integer>> answers) {
		ArrayList<String> profiles = getProfiles(answers.get(0));
		ArrayList<String> schools = getSchools(profiles, answers);
		return schools;
	}

}
