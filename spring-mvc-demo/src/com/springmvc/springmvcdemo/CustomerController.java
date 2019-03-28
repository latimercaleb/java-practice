package com.springmvc.springmvcdemo;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@InitBinder 
	public void bindToClearWhitespace(WebDataBinder dataBind) {
		// @InitBinder is an annotation that functions as a pre-processor, so all requests that come through the controller must parse it first. 
		// Can use initBinder to remove leading & trailing whitespace
		
		// From Spring API setting true in the constructor tells it to remove whitespace, if string is only whitespace it will get trimmed into null
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		// Adds this editor to the web binder to force it onto values
		dataBind.registerCustomEditor(String.class, stringTrimmerEditor);
	}
	
	@RequestMapping("/form")
	public String getCustomerForm(Model myModel) {
		myModel.addAttribute("customer", new Customer());
		return "customer-form";
	}
	
	@RequestMapping("/processCustomer")
	public String getCustomerResult(@Valid @ModelAttribute("customer") Customer aCustomer, BindingResult validationResponse) {
		// Check for errors in this endpoint 
		// @Valid: performs validation rules on the model object 
		// BindingResult contains the results of that validation
		if (validationResponse.hasErrors()) {
			System.out.println("The error is: " + validationResponse);
			return "customer-form";
		}
		else {
			return "customer-result";
		}
	}
}
