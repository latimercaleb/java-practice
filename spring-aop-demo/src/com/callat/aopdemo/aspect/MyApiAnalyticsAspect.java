package com.callat.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(0)
public class MyApiAnalyticsAspect {
	@Before("com.callat.aopdemo.aspect.PointCutExpressions.pointcutExampleForDaoPkg()")
	public void apiResolveAdvice() {
		System.out.println("**API resolution called on DAO()**");
	}
}
