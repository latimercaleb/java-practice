package com.annote_practice.spring_app_annotations;

import org.springframework.stereotype.Component;

@Component
public class KickBoxingCoach implements Coach {

	@Override
	public String getDailyWorkout() {
		return "Do your 50 kick combos!";
	}

}
