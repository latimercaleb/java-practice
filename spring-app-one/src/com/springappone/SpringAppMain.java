package com.springappone;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringAppMain {

	public static void main(String[] args) {
		
		// Make Spring container
		ClassPathXmlApplicationContext springContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		/* Passing in the interface will be fine, Spring will cast the correct object based on the id of the bean. 
		 * If the class implements methods outside of the interface however, the correct class must be specified in the second arg of getBean()
		 * DI, is handled via XML leaving you clean beans to instantiate and work with in the app's main code
		*/
		Coach trackCoach = springContext.getBean("TrackCoach", Coach.class);
		Coach baseballCoach = springContext.getBean("BaseballCoach", Coach.class);
		BoxingCoach boxingCoach = springContext.getBean("BoxingCoach", BoxingCoach.class);
		
		// Invoke bean methods 
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
		
		// Close up spring container
		springContext.close();
	}

}
