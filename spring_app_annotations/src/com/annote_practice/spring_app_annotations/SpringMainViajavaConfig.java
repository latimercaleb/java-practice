package com.annote_practice.spring_app_annotations;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMainViajavaConfig {

	public static void main(String[] args) {
		/* Since this is using a code version of a configuration file
		We use AnnotationConfigApplicationContext instead of ClassPathXmlApplicationContext which takes the name of the config file with .class
		*/
		AnnotationConfigApplicationContext springContext = new AnnotationConfigApplicationContext(StrengthConfig.class);
		
		// KickBoxingCoach coachInstance = springContext.getBean("kickBoxingCoach",KickBoxingCoach.class);
		SwimCoach swimCoach = springContext.getBean("swimCoach",SwimCoach.class);
		/*
		System.out.println(coachInstance.getDailyWorkout());
		System.out.println(coachInstance.getDailyFortune());
		coachInstance.makeFortune("Tacos and more tacos");
		System.out.println(coachInstance.getDailyFortune());
		*/
		System.out.println("\n");
		
		System.out.println(swimCoach.getDailyWorkout());
		System.out.println(swimCoach.getDailyFortune());
		swimCoach.makeFortune("Now it's even worse");
		System.out.println(swimCoach.getDailyFortune());
		System.out.println(swimCoach.getName());
		System.out.println(swimCoach.getTitle());
		springContext.close();
	}

}
