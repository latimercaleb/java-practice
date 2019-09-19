package com.callat.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {
	public boolean addTest() {
		System.out.println(getClass() + " : main process to add membership started");
		return true;
	}
}
