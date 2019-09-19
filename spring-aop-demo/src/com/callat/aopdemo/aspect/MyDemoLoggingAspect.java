package com.callat.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
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
}
