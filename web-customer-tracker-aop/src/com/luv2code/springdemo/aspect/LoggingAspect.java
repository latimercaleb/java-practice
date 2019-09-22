package com.luv2code.springdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.sun.istack.logging.Logger;

@Component
@Aspect
public class LoggingAspect {
	private static Logger theLogger = Logger.getLogger(LoggingAspect.class);
	
	@Before("com.luv2code.springdemo.aspect.AspectPointCuts.appFlow()")
	public void beforeAdvice(JoinPoint jp) {
		// Display method names & arguments
		theLogger.info("**@Before advice is calling method: " + jp.getSignature().toShortString());
		Object [] args = jp.getArgs();
		for(Object t : args) {
			theLogger.info("** Param in method: " + t);
		}
	}
	
	@AfterReturning(pointcut="com.luv2code.springdemo.aspect.AspectPointCuts.appFlow()",returning="returnObject")
	public void afterAdvice(JoinPoint jp, Object returnObject) {
		// Display the method returning from and data returned
		theLogger.info("**@AfterReturning advice is calling method: " + jp.getSignature().toShortString());
		theLogger.info("** Resulting Object will be: " + returnObject);
	}
	
}
