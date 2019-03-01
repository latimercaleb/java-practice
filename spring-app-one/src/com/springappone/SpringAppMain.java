package com.springappone;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringAppMain {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext springContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// pass in the interface, spring will cast the correct object based on the id of the bean
		// via DI, when these beans are made the dependencies are already added 
		Coach trackCoach = springContext.getBean("TrackCoach",Coach.class);
		Coach baseballCoach = springContext.getBean("BaseballCoach", Coach.class);
		BoxingCoach boxingCoach = springContext.getBean("BoxingCoach",BoxingCoach.class);
		
		System.out.println(trackCoach.getDailyTraining());
		System.out.println(trackCoach.getDailyFortune());
		
		System.out.println(baseballCoach.getDailyTraining());
		System.out.println(baseballCoach.getDailyFortune());
		
		System.out.println(boxingCoach.getDailyTraining());
		System.out.println(boxingCoach.getDailyFortune());
		System.out.println(boxingCoach.getGymName());
		System.out.println(boxingCoach.getWeightClass());
		
		System.out.println(boxingCoach.getEmail());
		System.out.println(boxingCoach.getChamp());
		System.out.println(boxingCoach.getMemberCount());
		springContext.close();
	}

}
