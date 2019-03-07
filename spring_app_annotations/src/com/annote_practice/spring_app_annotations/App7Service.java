package com.annote_practice.spring_app_annotations;

public class App7Service implements FortuneService {

	private String serviceMessage = "This is the default";
	
	@Override
	public String getFortune() {
		return this.serviceMessage;
	}

	@Override
	public void setFortune(String arg) {
		this.serviceMessage = arg;
	}

}
