// Setter DI with annotations
package com.annote_practice.spring_app_annotations;

import org.springframework.stereotype.Component;

@Component("customCoach")
public class SwimCoach implements Coach {

	@Override
	public String getDailyWorkout() {
		return "Do 10 laps";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void makeFortune(String arg) {
		// TODO Auto-generated method stub
		
	}

}
