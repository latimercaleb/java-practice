package com.luv2code.springdemo.service;

import java.util.List;

import com.luv2code.springdemo.entity.Customer;

public interface CustomerService {
	public List<Customer> getCustomers();

	public void saveCustomer(Customer enteredCustomer);

	public Customer getCustomer(int custId);

	public void deleteCustomer(int custId);
}
