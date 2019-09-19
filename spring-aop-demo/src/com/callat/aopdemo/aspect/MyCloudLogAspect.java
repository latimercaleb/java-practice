package com.callat.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyCloudLogAspect {
	@Before("com.callat.aopdemo.aspect.PointCutExpressions.pointcutExampleForDaoPkg()")
	public void checkCloudAdvice() {
		System.out.println("**Cloud User accessed cloud on DAO()**");
	}
}
