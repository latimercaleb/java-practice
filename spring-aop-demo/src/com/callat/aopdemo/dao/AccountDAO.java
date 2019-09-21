package com.callat.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.callat.aopdemo.Account;

@Component
public class AccountDAO {
	
	public String name;
	public String serviceCode;
	
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
	
	public String getName() {
		System.out.println(getClass() + " : getName() called");
		return name;
	}

	public void setName(String name) {
		System.out.println(getClass() + " : setName() called");
		this.name = name;
	}

	public String getServiceCode() {
		System.out.println(getClass() + " : getService() called");
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println(getClass() + " : setService() called");
		this.serviceCode = serviceCode;
	}
	
	public List<Account> findAccounts(boolean triggerException){
		
		if(triggerException) {
			throw new RuntimeException("Custom exception triggered and returned");
		}
		
		List<Account> accountList = new ArrayList<>();
		accountList.add(new Account ("Joker","Arsene"));
		accountList.add(new Account ("Panther","Hecate"));
		accountList.add(new Account ("Makoto","Agnes"));
		return accountList;
	}
	
}
