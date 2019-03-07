package com.annote_practice.spring_app_annotations;

import org.springframework.stereotype.Component;

@Component
public class RestService implements FortuneService {

	@Override
	public String getFortune() {
		return "Rest Service added";
	}

	@Override
	public void setFortune(String arg) {}
}
