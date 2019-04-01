package com.springmvc.springmvcdemo;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.springmvc.springmvcdemo.validation.CourseCode;

// Source class to practice validation with Spring MVC
public class Customer {
	private String firstName;
	
	// Requirement is to force validation on the last name and we do that with the following annotations
	// Error message displayed on failed validation
	@NotNull(message="This cannot be null or whitespace") 
	@Size(min=1,message="This field is required")
	private String lastName;
	
	// Max & min validation annotation practice
	@Max(value=10, message="Hey, don't be greedy!")
	@Min(value=0, message="Coupons must be positive!")
	@NotNull(message="You must have a coupon") 
	private Integer coupons;
	
	@Pattern(regexp="^[0-9]{5}", message="Only 5 digit zip allowed")
	private String zip;
	
	
	// Add custom annotation value on main class, can provide custom messages or use defaults
	@CourseCode
	// @CourseCode(value="400", message="Must Start with 400")
	public String courseCode;
	
	public String getCourseCode() {
		return courseCode;
	}
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
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
	public Integer getCoupons() {
		return coupons;
	}
	public void setCoupons(Integer coupons) {
		this.coupons = coupons;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	} 
}
