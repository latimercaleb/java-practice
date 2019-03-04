package com.springappone;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext cont = new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");
		TrackCoach coachA = cont.getBean("TrackCoach",TrackCoach.class);
		TrackCoach coachB = cont.getBean("TrackCoach",TrackCoach.class);
		
		// are they the same object?
		boolean result = (coachA == coachB);
		System.out.println("Same object?: " + result);
		// By default printing the bean prints the fully qualified name and memory address
		// Not having scope="prototype", they are the same, use it and they are different 
		System.out.println("Memory location of coachA?: " + coachA);
		System.out.println("Memory location of coachA?: " + coachB);
		
		cont.close();
	}

}
