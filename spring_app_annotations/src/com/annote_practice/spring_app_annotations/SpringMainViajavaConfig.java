package com.annote_practice.spring_app_annotations;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMainViajavaConfig {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext springContext = new AnnotationConfigApplicationContext(StrengthConfig.class);
		
		KickBoxingCoach coachInstance = springContext.getBean("kickBoxingCoach",KickBoxingCoach.class);
		SwimCoach customCoach = springContext.getBean("customCoach",SwimCoach.class);
		
		System.out.println(coachInstance.getDailyWorkout());
		System.out.println(coachInstance.getDailyFortune());
		coachInstance.makeFortune("Tacos and more tacos");
		System.out.println(coachInstance.getDailyFortune());
		System.out.println(customCoach.getDailyWorkout());
		springContext.close();
	}

}
