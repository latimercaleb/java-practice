package com.luv2code.springdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AspectPointCuts {
	@Pointcut("execution(* com.luv2code.springdemo.controller.*.*(..))")
	public void controllerPC() {}
	
	@Pointcut("execution(* com.luv2code.springdemo.service.*.*(..))")
	public void servicePC() {}
	
	@Pointcut("execution(* com.luv2code.springdemo.dao.*.*(..))")
	public void daoPC() {}
	
	@Pointcut("controllerPC() || servicePC() || daoPC()")
	public void appFlow() {}
}
