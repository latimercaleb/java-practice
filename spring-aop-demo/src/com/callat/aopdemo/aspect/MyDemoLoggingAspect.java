package com.callat.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.callat.aopdemo.Account;

@Aspect
@Component
@Order(1)
public class MyDemoLoggingAspect {
	// This class will handle all aspects for loading logging
	// @Before("execution(public void addAccount())") // Pointcut Exp: Match on any method name 
	// @Before("execution( void com.callat.aopdemo.dao.AccountDAO.addAccount())") // Match on only a method from a certain class
	// @Before("execution( void add*())") // Match on wildcard string
    // @Before("execution( * add*())") // Match on any return type using wildcard 
    // @Before("execution( * add*(com.callat.aopdemo.Account))") // Param type: Class
    // @Before("execution( * add*(com.callat.aopdemo.Account, ..))") // Param type: Class + any other objects
	// @Before("execution( * add*(com.callat.aopdemo.Account, boolean))") // Same as above but passing in datatype of param specifically, more secure
	// @Before("execution( * add*(..))") // Pass in anything
	// @Before("execution(* com.callat.aopdemo.dao.*.*(..))") // Any class, any method, any number of params as long as it's in the package
	// @Before("pointcutExampleForDaoPkg()") // Applying custom pointcut declaration 
	@Before("com.callat.aopdemo.aspect.PointCutExpressions.noGetSet()") // Applying combinatric custom pointcut
	public void beforeAddAccountAdvice() {
		System.out.println("**Logging addAccount() transaction**");
	}
	// Point cut expressions are now moved into their own class making them public and thus accessible for the rest of the aspect classes 
	
	// Join point practice
	@Before("com.callat.aopdemo.aspect.PointCutExpressions.lastOnly()")
	public void beforeLastAcct(JoinPoint jp) {
		System.out.println("\n\n**JOIN POINT CASE**");
		// Print the method signature
		MethodSignature methodSig = (MethodSignature) jp.getSignature();
		System.out.println("Method Name: " + methodSig + "\n");
		
		// Print the parameters passed into the method
		Object[] args = jp.getArgs();
		for(Object t : args) {
			System.out.println("Param: " + t);
			
			// Since a param is a class name doing a 'down-cast' is important for telemetry
			if(t instanceof Account) {
				Account callingAcct = (Account) t;
				System.out.println("Account detected!");
				System.out.println("Account Name: " + callingAcct.getName());
				System.out.println("Account Level: " + callingAcct.getLevel());
			}
		}
	}
	
	// After returning advice
	@AfterReturning(pointcut="com.callat.aopdemo.aspect.PointCutExpressions.findAccountsAdvice()",returning="theList")
	public void afterReturningFindAccountsAdvice(JoinPoint jp, List<Account> theList) {
		System.out.println("@AfterReturning started");
		System.out.println("Executing on: " + jp.getSignature().toShortString());
		System.out.println("@AfterReturning value received is " + theList);
		
		// To post process, all caps for example, do operations on the the "returning" value 
		for (Account i:theList) {
			i.setName(i.getName().toUpperCase());
		}
		
		System.out.println("@AfterReturning value at completion is " + theList);
	}
	
	// After Throwing advice here
	@AfterThrowing(pointcut="com.callat.aopdemo.aspect.PointCutExpressions.findAccountsAdvice()",throwing="theExc")
	public void afterReturningExceptionFindAccounts(JoinPoint jp, Throwable theExc) {
		System.out.println("@AfterThrowing started");
		System.out.println("Executing on: " + jp.getSignature().toShortString());
		System.out.println("@AfterThrowing value received is " + theExc);
		System.out.println("@AfterThrowing COMPLETE");
	}
	
	// After advice here
	@After("com.callat.aopdemo.aspect.PointCutExpressions.findAccountsAdvice()")
	public void afterFindAccounts(JoinPoint jp) {
		System.out.println("@After started");
		System.out.println("Executing on: " + jp.getSignature().toShortString());
		System.out.println("@After COMPLETE");
	}
	
	// Around advice 
	@Around("com.callat.aopdemo.aspect.PointCutExpressions.getFortunePC()")
	public Object aroundGetFortune(ProceedingJoinPoint jp) throws Throwable{
		System.out.println("@Around started");
		long begin = System.currentTimeMillis();
		Object rez = null;
		try {
			rez = jp.proceed();
		}catch(Exception e) {
			System.out.println("Exception triggered here: " + e.getMessage());
			rez = "Stub code for err handling"; // Handle and resolve exception
			// throw e; // rethrow exception back up to main (the calling method)
		}
		long end = System.currentTimeMillis();
		long duration = end-begin;
		System.out.println("@Around COMPLETE");
		System.out.println("Total Duration: " + duration/1000 + " secs");
		return rez;
	}

}
