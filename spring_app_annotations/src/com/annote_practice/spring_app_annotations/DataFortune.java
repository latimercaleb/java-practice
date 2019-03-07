package com.annote_practice.spring_app_annotations;

import org.springframework.stereotype.Component;

@Component
public class DataFortune implements FortuneService {

	@Override
	public String getFortune() {
		return "Data Service called";
	}

	@Override
	public void setFortune(String arg) {}
}
