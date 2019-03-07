package com.annote_practice.spring_app_annotations;

import org.springframework.beans.factory.annotation.Value;

public class App7Coach implements Coach {
	
	private App7Service appService;
	
	@Value("${app7.name}")
	private String name;
	
	@Value("${app7.number}")
	private String number;
	
	public App7Coach(App7Service paramService) {
		this.appService = paramService;
	}
	@Override
	public String getDailyWorkout() {
		return "This is app 7";
	}

	@Override
	public String getDailyFortune() {
		return this.appService.getFortune();
	}

	@Override
	public void makeFortune(String arg) {
		this.appService.setFortune(arg);
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getNumber() {
		return this.number;
	}
}
