package com.calat.jackson.json.demo;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Driver {

	public static void main(String[] args) {
		try {
			// Use object mapper to Import JSON -> POJO 
			ObjectMapper mapper = new ObjectMapper();
			Student simpleStudent = mapper.readValue(new File("data/sample-lite.json"), Student.class);
			Student advancedStudent = mapper.readValue(new File("data/sample-full.json"), Student.class);
			// Do something with object 
			System.out.println("Simple First name is: " + simpleStudent.getFirstName());
			System.out.println("Simple Last name is: " + simpleStudent.getLastName());
			System.out.println("Simple Id is: " + simpleStudent.getId());
			
			System.out.println("Advanced First name is: " + advancedStudent.getFirstName());
			System.out.println("Advanced Last name is: " + advancedStudent.getLastName());
			System.out.println("Advanced Id is: " + advancedStudent.getId());
			System.out.println("Advanced Address is: " + advancedStudent.getAddress().getStreet() + " " + advancedStudent.getAddress().getCity() + ", " + advancedStudent.getAddress().getState() + " " + advancedStudent.getAddress().getZip() + " " + advancedStudent.getAddress().getCountry());
			System.out.print("Advanced Languages is: ");
			for(String tmp : advancedStudent.getLanguages()){
				System.out.print(tmp + " ");
			}
			// Export into new json
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
