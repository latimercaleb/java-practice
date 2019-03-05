package com.annote_practice.spring_app_annotations;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMainBeanScope {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext spring = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Coach coachA = spring.getBean("kickBoxingCoach", Coach.class);
		Coach coachB = spring.getBean("kickBoxingCoach", Coach.class);
		
		boolean cmp = (coachA == coachB);
		System.out.println("Result is: " + cmp);
		System.out.println("Memory loc of coachA: " + coachA);
		System.out.println("Memory loc of coachB: " + coachB);
		spring.close();

	}

}
