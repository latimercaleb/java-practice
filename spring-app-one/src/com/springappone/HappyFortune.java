package com.springappone;

public class HappyFortune implements FortuneService {

	@Override
	public String getFortune() {
		return "Today is your lucky day";
	}
	
}
