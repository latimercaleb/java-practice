package com.luv2code.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
//	@Autowired 
//	private CustomerDAO customerDAO; // No longer injecting the DAO directly, inject the service instead
	
	@Autowired
	private CustomerService customerService;
	
  //@PostMapping("/list") // Handles only get requests
  //@RequestMapping("/list") // Handles all URL requests
	@GetMapping("/list")
	public String listCustomers(Model theModel) {
		// Fetch customers via dao or service and then assign the customers to a spring model, this will feed into the JSP page
		List<Customer> customers = customerService.getCustomers();
		theModel.addAttribute("customers",customers);
		return "list-customers";
	}
	
	@RequestMapping("/show-form")
	public String showForm(Model theModel) {
		Customer newCustomer = new Customer();
		theModel.addAttribute("customer", newCustomer);
		return "customer-form";
	}
	
	@GetMapping("/show-form-update")
	public String showFormUpdate(@RequestParam("customerId") int custId, Model theModel) {
		Customer theCustomer = customerService.getCustomer(custId);
		theModel.addAttribute("customer", theCustomer);
		return "customer-form";
	}
	
	
	@PostMapping("/save-form")
	public String saveCustomer(@ModelAttribute("customer") Customer enteredCustomer) {
		// Parse result from form then save using service reload list view
		customerService.saveCustomer(enteredCustomer);
		return "redirect:/customer/list";
	}
	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") int custId, Model theModel) {
		customerService.deleteCustomer(custId);
		return "redirect:/customer/list";
	}
}
