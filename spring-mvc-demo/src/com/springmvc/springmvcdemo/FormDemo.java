package com.springmvc.springmvcdemo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FormDemo {
	
	@RequestMapping("/showForm")
	public String renderForm() {
		return "show-form";
	}
	
	@RequestMapping("/processForm")
	public String renderResponse() {
		return "show-response";
	}
}
