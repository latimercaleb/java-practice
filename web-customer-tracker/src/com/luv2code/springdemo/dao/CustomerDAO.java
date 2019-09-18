package com.luv2code.springdemo.dao;

import java.util.List;
import com.luv2code.springdemo.entity.Customer;

public interface CustomerDAO {
	public List<Customer> getCustomers();

	public void saveCustomer(Customer enteredCustomer);

	public Customer getCustomer(int custId);

	public void deleteCustomer(int custId);
}
