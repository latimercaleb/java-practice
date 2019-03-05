package com.annote_practice.spring_app_annotations;

import org.springframework.stereotype.Component;

@Component("customCoach")
public class SwimCoach implements Coach {

	@Override
	public String getDailyWorkout() {
		return "Do 10 laps";
	}

}
