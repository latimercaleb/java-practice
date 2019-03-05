package com.annote_practice.spring_app_annotations;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMain {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext springContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		KickBoxingCoach coachInstance = springContext.getBean("kickBoxingCoach",KickBoxingCoach.class);
		SwimCoach customCoach = springContext.getBean("customCoach",SwimCoach.class);
		System.out.println(coachInstance.getDailyWorkout());
		System.out.println(customCoach.getDailyWorkout());
		springContext.close();
	}

}
