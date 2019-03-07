package com.annote_practice.spring_app_annotations;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMain {

	public static void main(String[] args) {
		// Construct spring container based off xml file
		ClassPathXmlApplicationContext springContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// Extract beans from container
		KickBoxingCoach coachInstance = springContext.getBean("kickBoxingCoach",KickBoxingCoach.class);
		SwimCoach customCoach = springContext.getBean("customCoach",SwimCoach.class);
		
		// Call methods from beans and do logic
		System.out.println(coachInstance.getDailyWorkout());
		System.out.println(coachInstance.getDailyFortune());
		coachInstance.makeFortune("Tacos and more tacos");
		System.out.println(coachInstance.getDailyFortune());
		System.out.println(customCoach.getDailyWorkout());
		
		// close container before program terminates
		springContext.close();
	}

}
