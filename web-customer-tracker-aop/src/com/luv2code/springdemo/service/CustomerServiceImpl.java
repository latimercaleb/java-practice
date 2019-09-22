package com.luv2code.springdemo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luv2code.springdemo.dao.CustomerDAO;
import com.luv2code.springdemo.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDAO customerDAO;
	
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		// Wrap DAO calls in transactional, and delegate call
		return customerDAO.getCustomers();
	}

	// Now implement the new method
	@Override
	@Transactional
	public void saveCustomer(Customer enteredCustomer) {
		customerDAO.saveCustomer(enteredCustomer);
		
	}

	@Override
	@Transactional
	public Customer getCustomer(int custId) {
		return customerDAO.getCustomer(custId);
	}

	@Override
	@Transactional
	public void deleteCustomer(int custId) {
		 customerDAO.deleteCustomer(custId);
	}
	
	
	

}
