package com.springmvc.springmvcdemo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MultiPathController {
	
	// This won't work since we already have the mapping on /showForm in another controller, this will throw a 500 error, the other show form has to be quantified
	@RequestMapping("/showForm")
	public String wontDisplayForm() {
		// No view name here since this controller won't even build, 
		return "temp";
	}
}
