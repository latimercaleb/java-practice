package com.springmvc.springmvcdemo;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

// Source class to practice validation with Spring MVC
public class Customer {
	private String firstName;
	
	// Requirement is to force validation on the last name and we do that with the following annotations
	// Error message displayed on failed validation
	@NotNull(message="This cannot be null or whitespace") 
	@Size(min=1,message="This field is required")
	private String lastName;
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
}
