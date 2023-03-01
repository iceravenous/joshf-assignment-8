package com.coderscampus.assignment8;

import java.util.ArrayList;
import java.util.List;

public class DataService {
	Assignment8 assignment = new Assignment8();

	public List<Integer> getData() {
//		Assignment8 assignment = new Assignment8();
		List<Integer> numbersList = new ArrayList<>();
		for (int i=0;i<20; i++) {
		numbersList.addAll(assignment.getNumbers());
		}
		
		return numbersList;


	}
	
}
