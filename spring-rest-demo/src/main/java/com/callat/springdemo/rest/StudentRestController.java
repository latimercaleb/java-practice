package com.callat.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

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
	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId) {
		return theStudents.get(studentId);	// Returns index if within list
	}
}
