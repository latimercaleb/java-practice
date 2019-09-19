package com.callat.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.callat.aopdemo.dao.AccountDAO;
import com.callat.aopdemo.dao.MembershipDAO;
import com.callat.aopdemo.Account;
public class MainDemoApp {

	public static void main(String[] args) {
		// Wire up new context from Java config, make new bean, call method then close context
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		AccountDAO daoObj = context.getBean("accountDAO", AccountDAO.class);
		MembershipDAO otherDao = context.getBean("membershipDAO", MembershipDAO.class);
		Account myAccount = new Account();
		
		daoObj.addAccount(myAccount);
		daoObj.addAccounts(myAccount, true);
		daoObj.addLastAcct(myAccount, true, "a random string");
		System.out.println("\n Second attempt \n");
		otherDao.addTest();
		context.close();

	}

}
