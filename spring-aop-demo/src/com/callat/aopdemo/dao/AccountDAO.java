package com.callat.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.callat.aopdemo.Account;

@Component
public class AccountDAO {
	public void addAccount(Account theAccount) {
		System.out.println(getClass() + " : main process to add account started");
	}
	
	public void addAccounts(Account theAccount, boolean flag) {
		System.out.println(getClass() + " : main process to add account started");
	}
	
	public String addLastAcct(Account theAccount, boolean flag, String test) {
		System.out.println(getClass() + " : main process to add account started");
		return test;
	}
}
