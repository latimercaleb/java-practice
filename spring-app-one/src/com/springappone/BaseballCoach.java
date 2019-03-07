package com.springappone;

public class BaseballCoach implements Coach {
	
	// Make a private field for dependency
	private FortuneService fortuneService;
	
	// Make blank constructor
	public BaseballCoach() {}
	
	// Make setter method to set dependency
	public void setFortuneService (FortuneService thefortuneService) {
		this.fortuneService = thefortuneService;
	}
	
	@Override
	public String getDailyTraining() {
		return "Spend a half hour on batting practice";
	}
	
	// Override dependency interface and make use of method in class
	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
}
