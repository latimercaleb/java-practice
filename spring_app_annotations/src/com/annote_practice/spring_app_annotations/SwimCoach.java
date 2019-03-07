// Setter DI with annotations
package com.annote_practice.spring_app_annotations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

// @Component("customCoach")
public class SwimCoach implements Coach {
	private FortuneService badFortune;
	
	@Value("${swim.name}")
	private String coachName;
	
	@Value("${swim.title}")
	private String lastTitle;
	
	public SwimCoach(FortuneService newFortune) {
		this.badFortune = newFortune;
	}
	
	@Override
	public String getDailyWorkout() {
		return "Do 10 laps";
	}

	@Override
	public String getDailyFortune() {
		return this.badFortune.getFortune();
	}

	@Override
	public void makeFortune(String arg) {
		this.badFortune.setFortune(arg);
	}
	
	public String getName() {
		return this.coachName;
	}
	
	public String getTitle() {
		return this.lastTitle;
	}
}
