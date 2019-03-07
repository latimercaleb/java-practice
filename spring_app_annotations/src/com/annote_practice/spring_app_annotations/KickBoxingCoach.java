// Constructor DI with Spring Annotations
package com.annote_practice.spring_app_annotations;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
// @Scope("prototype")
public class KickBoxingCoach implements Coach {
	// Direct based autowire
	@Autowired
	@Qualifier("app5FortuneService")
	private FortuneService kickFortune;
	
//	// Setter based autowire, requires blank constructor
//	public KickBoxingCoach() {...}
	
//	@Autowired
//	public void setFortuneService(FortuneService afortuneService) {
//		this.kickFortune = afortuneService;
//	}
	
// // Constructor based autowire
//	@Autowired
//	public KickBoxingCoach(FortuneService newService) {
//		this.kickFortune = newService;
//	}
	
	@Override
	public String getDailyWorkout() {
		return "Do your 50 kick combos!";
	}
	
	@Override
	public void makeFortune(String arg) {
		this.kickFortune.setFortune(arg);
	}
	
	@Override
	public String getDailyFortune() {
		return this.kickFortune.getFortune();
	}
	
	@PostConstruct
	public void customInit() {
		System.out.println("Custom start up method runs ...");
	}
	@PreDestroy
	public void customDestroy() {
		System.out.println("Custom destroy method runs ...");
	}

}
