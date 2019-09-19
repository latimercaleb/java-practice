package com.callat.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
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
	@Before("execution(* com.callat.aopdemo.dao.*.*(..))") // Any class, any method, any number of params as long as it's in the package
	public void beforeAddAccountAdvice() {
		System.out.println("\n**Logging aspect: @Before advice on public void addAccount()");
	}
}
