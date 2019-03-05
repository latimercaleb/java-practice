package com.annote_practice.spring_app_annotations;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortune implements FortuneService {
	private String[] messages = {"Random Message 1", "Let's be witty for message 2", "Message 2 is not witty at all"};
	private Random rand = new Random();
	private boolean newFortuneAdded = false;
	private String newFortune = "";
	
	@Override
	public String getFortune() {
		return newFortuneAdded ? newFortune : messages[rand.nextInt(messages.length)];
	}

	@Override
	public void setFortune(String arg) {
		newFortuneAdded = true;
		this.newFortune = arg;

	}

}
