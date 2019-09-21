package com.callat.aopdemo;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.callat.aopdemo.dao.AccountDAO;
import com.callat.aopdemo.dao.MembershipDAO;
import com.callat.aopdemo.service.TrafficFortuneService;
public class MainDemoApp {

	private static Logger springLogger = Logger.getLogger(MainDemoApp.class.getName()); // Accessing internal java logger
	public static void main(String[] args) {
		// Wire up new context from Java config, make new bean, call method then close context
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		

		AccountDAO daoObj = context.getBean("accountDAO", AccountDAO.class);
		MembershipDAO otherDao = context.getBean("membershipDAO", MembershipDAO.class);
		TrafficFortuneService trafficService = context.getBean("trafficFortuneService",TrafficFortuneService.class);	
		Account myAccount = new Account();
		
		daoObj.addAccount(myAccount);
		daoObj.addAccounts(myAccount, true);
		myAccount.setName("Joylne Kujo");
		myAccount.setLevel("Stone Ocean");
		daoObj.addLastAcct(myAccount, true, "a random string");
		System.out.println("\n Second attempt \n");
		otherDao.addTest();
		
		
		System.out.println("\n \n Demo for Pointcut combinatrics \n \n");
		
		daoObj.setName("Test");
		daoObj.setServiceCode("Exam");
		
		String name = daoObj.getName();
		String service = daoObj.getServiceCode();
		
		System.out.println("\n\n Demo of @AfterReturning \n \n");
		List<Account> accountList = daoObj.findAccounts(false);
		System.out.println("Returning the list as: " + accountList);
		
		System.out.println("\n\n Demo of @AfterThrowing \n \n");
		List<Account> exceptionAccountList = null;
		try {
			exceptionAccountList = daoObj.findAccounts(true);
		}catch(Exception e) {
			System.out.println("Exception captured in main method of " + e);
		}
		
		System.out.println("\n\n Demo of @After \n \n");
		List<Account> afterList = null;
		try {
			afterList = daoObj.findAccounts(false); // This value can alternate, either way @After should run properly
		}catch(Exception e) {
			System.out.println("Exception captured in main method of " + e);
		}
		
		System.out.println("\n\n Demo of @Around \n \n");
		String data = trafficService.getFortune();
		System.out.println("Service was called. End of @Around w/ data of: " + data);
		
		
		System.out.println("\n\n Demo of @Around + Logger \n \n");
		String data_2 = trafficService.getFortune();
		springLogger.info("Service was called. End of @Around w/ data of: " + data_2);
		
		System.out.println("\n\n Demo of @Around + Exception consumption\n \n");
		String data_3 = trafficService.getFortune(true);
		System.out.println("Service was called. End of @Around w/ data of: " + data_3);
		
		context.close();

	}

}
