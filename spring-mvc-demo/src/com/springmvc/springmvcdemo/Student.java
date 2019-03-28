package com.springmvc.springmvcdemo;

import java.util.LinkedHashMap;

// Since student is the type we want we declare it here with getter, setter and constructor
// Spring will recognize what this is within the model implicitly since it's part of the package
public class Student {
	private String firstName;
	private String lastName;
	private String country;
	
	// Generate a list of countries to not hard code list
	private LinkedHashMap<String,String> countryContainer;
	public Student () {
		
		countryContainer = new LinkedHashMap<>();
		countryContainer.put("US","United States");
		countryContainer.put("JP","Japan");
		countryContainer.put("NG","Nigeria");
		countryContainer.put("PO","Poland");
		
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public LinkedHashMap<String,String> getCountryContainer() {
		return countryContainer;
	}
}
