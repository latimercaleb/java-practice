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
	// @Transactional // Removing this because transactional is in the service level, not the DAO
	public List<Customer> getCustomers() {
		// Fetch transaction and query all customers and return the list
		Session localSession = sessionFactory.getCurrentSession();
		Query<Customer> theQuery = localSession.createQuery("from Customer order by lastName", Customer.class);
		List<Customer> customers = theQuery.getResultList();
		return customers;
	}

	@Override
	public void saveCustomer(Customer enteredCustomer) {
		// Use saveOrUpdate(...) because it does PUT and POST
		Session localSession = sessionFactory.getCurrentSession();
		localSession.saveOrUpdate(enteredCustomer);
	}

	@Override
	public Customer getCustomer(int custId) {
		Session localSession = sessionFactory.getCurrentSession();
		Customer customer = localSession.get(Customer.class, custId);
		return customer;
	}

	@Override
	public void deleteCustomer(int custId) {
		Session localSession = sessionFactory.getCurrentSession();
		Query<Customer> theQuery = localSession.createQuery("DELETE from Customer WHERE id=:cust_id");
		theQuery.setParameter("cust_id", custId);
		theQuery.executeUpdate();
	}

}
