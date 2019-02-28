package com.springappone;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext springContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		// pass in the interface, spring will cast the correct object based on the id of the bean
		Coach newCoach = springContext.getBean("coach",Coach.class);
		System.out.print(newCoach.getDailyTraining());
		springContext.close();
	}

}
