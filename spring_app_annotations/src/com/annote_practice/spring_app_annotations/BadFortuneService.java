package com.annote_practice.spring_app_annotations;

public class BadFortuneService implements FortuneService {
	private String badFortune;
	
	public BadFortuneService() {
		this.badFortune = "Today is not your day";
	}
	
	@Override
	public String getFortune() {
		return this.badFortune;
	}

	@Override
	public void setFortune(String arg) {
		this.badFortune = arg;
	}

}
