package com.springmvc.springmvcdemo.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String>{
	// local var used to contain part to validate
	private String coursePrefix;
	@Override 
	public void initialize(CourseCode theCourseCode) {
		coursePrefix = theCourseCode.value(); 
		// Should return the value of the annotation that we want to validate against
	}
	@Override
	public boolean isValid(String theCourseCode, ConstraintValidatorContext theCourseCodeContext) {
		// first arg is actual argument from html 
		// second arg is optional but allows further filtering of custom error messages
		boolean result;
		if (theCourseCode != null) {
			result = theCourseCode.startsWith(coursePrefix);
		}else {
			result = true;
		}
		return result;
	}
	
}
