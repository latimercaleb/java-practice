package com.springappone;

public class BoxingCoach implements Coach {
	private FortuneService fortuneService;
	
	// Add fields for injection 
	private String gymName;
	private String weightClass;
	private int memberCount;
	private String email;
	private String champ;
	
	// Add fields for bean life-cycle messaging
	private String inMessage;
	private String outMessage;
	
	
	// Add methods for init/destroy methods 
	private void doInit() {
		System.out.println(this.inMessage);
	}
	
	private void doDestroy() {
		System.out.println(this.outMessage);
	}
	
	// Then add setters for those fields to be picked up by the context
	public void setGymName(String name) {
		this.gymName = name;
	}
	
	public void setWeightClass(String weightClass) {
		this.weightClass = weightClass;
	}
	
	public void setMemberCount(int newCount){
		this.memberCount = newCount;
	}
	
	public void setChamp(String newChamp) {
		this.champ = newChamp;
	}
	
	public void setEmail(String newEmail) {
		this.email = newEmail;
	}
	
	// Inject Service via Constructor
	public BoxingCoach(FortuneService afortuneService) {
		fortuneService = afortuneService;
		this.inMessage = "Boxing Coach, initHook Called!";
		this.outMessage = "Boxing Coach, destroyHook Called!"; 
	}
	@Override
	public String getDailyTraining() {
		String trainingPlan = "Spar 2 rounds";
		return trainingPlan;
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
	
	public String getGymName() {
		return gymName;
	}
	
	public String getWeightClass() {
		return weightClass;
	}
	
	public int getMemberCount() {
		return memberCount;
	}
	public String getChamp() {
		return champ;
	}
	public String getEmail() {
		return email;
	}
}
