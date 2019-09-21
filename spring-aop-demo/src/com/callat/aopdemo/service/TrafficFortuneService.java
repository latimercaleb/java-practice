package com.callat.aopdemo.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

@Component
public class TrafficFortuneService {
	public String getFortune() {
		try {
			TimeUnit.SECONDS.sleep(5);
		}catch(Exception exc) {
			System.out.println("System error: " + exc);
		}
		return "Traffic will be awful"; 
	}
	public String getFortune(boolean t) {
		if(t) {
			throw new RuntimeException("Major collision on I-275!");
		}
		return getFortune(); 
	}
}
