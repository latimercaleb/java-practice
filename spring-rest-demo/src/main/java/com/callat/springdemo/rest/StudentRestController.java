package com.callat.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.callat.springdemo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	private List<Student> theStudents;
	
	@PostConstruct
	public void loadData() {
		theStudents = new ArrayList<>();
		theStudents.add(new Student("Johnny", "Test"));
		theStudents.add(new Student("Strawhat", "Luffy"));
		theStudents.add(new Student("Dr", "Senku"));
		theStudents.add(new Student("Giorno", "Giovanna"));
		theStudents.add(new Student("Strider", "Hotsuma"));
	}
	// Return list of students
	@GetMapping("/students")
	public List<Student> getStudents(){
		// Hardcoded for now crud stuff later
		return theStudents;
	}
	
	// Return student by id at an index
	// Could cause exception here, so check the studentId is valid with exception handling
	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId) {
		 if(studentId >= theStudents.size() || studentId < 0) {
			 throw new StudentNotFoundException("Student ID not found: " + studentId); // throw exception
		 }else {
			 return theStudents.get(studentId);	// Returns index if within list
		 }
	}
	
	// Could have exception handlers here and remove the AOP class of StudentRestExceptionHandler.java without change the methods
}
