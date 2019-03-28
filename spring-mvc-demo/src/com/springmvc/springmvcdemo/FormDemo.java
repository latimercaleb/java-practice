package com.springmvc.springmvcdemo;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello") // Parent Mapping
public class FormDemo {
	
	@RequestMapping("/showForm")
	public String renderForm() {
		return "show-form";
	}
	
	@RequestMapping("/processForm")
	public String renderResponse() {
		return "show-response";
	}
	
	@RequestMapping("/processFormV2") // Sub mapping
	public String renderTransformedData(HttpServletRequest req, Model dataContainer) {
		// Above pass in form data and a model
		// Extract request parameter that is passed in from form with name='userName' on form
		String userName = req.getParameter("userName");
		userName = userName.toUpperCase();
		userName = "I can hear you typing, " + userName;
		// Add new string to model, now we can use it later.
		dataContainer.addAttribute("threaten",userName);
		return "show-response";
	}
	
	// Use of @RequestParam annotation to fetch param from request and bind it to variable
	@RequestMapping("/processFormV3")
	public String renderTransformedData2(@RequestParam("userName") String req, Model dataContainer) {
		String userName = req.toUpperCase();
		userName = "Version 3 use the annotations! " + userName;
		dataContainer.addAttribute("threaten",userName);
		return "show-response";
	}
}
