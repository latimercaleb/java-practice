package com.luv2code.springdemo.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springdemo.entity.Customer;
@Repository
public class CustomerDAOImpl implements CustomerDAO {
	
	// Need to inject the session for the DAO, must have database connection in here
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		// Fetch transaction and query all customers and return the list
		Session localSession = sessionFactory.getCurrentSession();
		Query<Customer> theQuery = localSession.createQuery("from Customer", Customer.class);
		List<Customer> customers = theQuery.getResultList();
		return customers;
	}

}
