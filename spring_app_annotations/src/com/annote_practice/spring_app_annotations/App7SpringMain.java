package com.annote_practice.spring_app_annotations;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App7SpringMain {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext springContext = new AnnotationConfigApplicationContext(App7Config.class);
		
		App7Coach app7 = springContext.getBean("app7Coach",App7Coach.class);
		
		System.out.println(app7.getDailyWorkout());
		System.out.println(app7.getDailyFortune());
		System.out.println(app7.getName());
		System.out.println(app7.getNumber());
		app7.makeFortune("Movies, good movies in your future");
		System.out.println(app7.getDailyFortune());
		
		springContext.close();
		
	}

}
