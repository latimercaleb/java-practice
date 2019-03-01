package com.springappone;

public class TrackCoach implements Coach {
	// Make a private field for dependency
	private FortuneService fortuneService;
	// Make constructor to handle said dependency
	public TrackCoach(FortuneService afortuneService) {
		fortuneService = afortuneService;
	}
	
	@Override
	public String getDailyTraining() {
		return "Run 3k and do some stretches";
	}
	// Call dependency
	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
