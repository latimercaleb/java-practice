package com.springmvc.springmvcdemo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

// Controller for Student, handles student http requests
@Controller
@RequestMapping("/student")
public class StudentController {
	@RequestMapping("/presentForm")
	public String presentStudentForm(Model dataModel) {
		// generate new student object
		Student myStudent = new Student();
		// apply it as a model attribute 
		dataModel.addAttribute("student", myStudent);
		return "student-form";
	}
	
	@RequestMapping("/processStudentForm")
	public String renderStudentData(@ModelAttribute("student") Student theStudent){
		// Model attribute above must use the same key declared in the model to access value 
		
		// Good practice to log data retrieved from model before attempting to write to a view
		System.out.println("Student name: " + theStudent.getFirstName() + ", " + theStudent.getLastName() + ", " + theStudent.getCountry());
		return "show-student-response";
	}
}
