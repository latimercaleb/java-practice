package com.callat.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
public class PointCutExpressions {
	@Pointcut("execution(* com.callat.aopdemo.dao.*.*(..))")
	public void pointcutExampleForDaoPkg() {}
	
	// Pointcut combination practice : Getters/ setters and include pkg but exclude getter and setter
	
	@Pointcut("execution(* com.callat.aopdemo.dao.*.get*(..))")
	public void getter() {}
	
	@Pointcut("execution(* com.callat.aopdemo.dao.*.set*(..))")
	public void setter() {}
	
	@Pointcut("pointcutExampleForDaoPkg() && !(getter() || setter())")
	public void noGetSet() {}
	
	@Pointcut("execution(* com.callat.aopdemo.dao.AccountDAO.addLastAcct(..))")
	public void lastOnly() {}
	
	@Pointcut("execution(* com.callat.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void findAccountsAdvice() {}
}
