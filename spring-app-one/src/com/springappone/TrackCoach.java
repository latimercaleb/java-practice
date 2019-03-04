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
	
	// Custom init hook 
	private void initHook() {
		int i = 24;
		System.out.println("System startup hook: " + i);
	}
	// Custom destroy hook
	private void destroyHook() {
		int i = 42;
		System.out.println("System cleanup hook: " + i);
	}

}
