package com.luv2code.springdemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerRestController {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/customers")
	public List <Customer> getCustomers(){
		return customerService.getCustomers();
	}
	
	@GetMapping("/customers/{customerId}")
	public Customer getCustomer(@PathVariable int customerId){
		 Customer theCustomer = customerService.getCustomer(customerId);
		 if(theCustomer == null) {
			 throw new CustomerNotFoundException("Customer id not found - " + customerId);
		 }
		 return theCustomer; // Need to return as pojo
	}
	
	@PostMapping("/customers")
	public Customer addCustomer(@RequestBody Customer theCustomer) {
		// Pass the object into the service to process as pojo
		theCustomer.setId(0); // Just in case an ID comes over somehow, if it does set it to 0 to not disrupt the hibernate dao process
		customerService.saveCustomer(theCustomer);
		return theCustomer;
	}
	
	@PutMapping("/customers")
	public Customer updateCustomer (@RequestBody Customer theCustomer) {
		customerService.saveCustomer(theCustomer);
		return theCustomer;
	}
	
	@DeleteMapping("/customers/{theCustomerId}")
	public String deleteCustomer (@PathVariable int theCustomerId) {
		 Customer theCustomer = customerService.getCustomer(theCustomerId);
		 if(theCustomer == null) {
			 throw new CustomerNotFoundException("Customer id not found - " + theCustomerId);
		 }
		customerService.deleteCustomer(theCustomerId);
		return "Deleted Customer ID: " + theCustomerId;
	}
}
