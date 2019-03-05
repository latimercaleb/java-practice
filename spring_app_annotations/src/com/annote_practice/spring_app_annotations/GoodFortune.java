package com.annote_practice.spring_app_annotations;

import org.springframework.stereotype.Component;

@Component
public class GoodFortune implements FortuneService {
	private String fortune;
	@Override
	public String getFortune() {
		return this.fortune;
	}

	@Override
	public void setFortune(String arg) {
		this.fortune = arg;
	}

}
