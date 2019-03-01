package com.springappone;

import java.util.Random;

public class HappyFortune implements FortuneService {

	@Override
	public String getFortune() {
		Random rand = new Random();
		int randNum = rand.nextInt(3);
		String [] randFortune = {"Today isn't your day","Luck embodied, fortune favors you","Today is useless, go back to bed"};
		return  randFortune[randNum];
	}
	
}
