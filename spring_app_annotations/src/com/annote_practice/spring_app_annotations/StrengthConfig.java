package com.annote_practice.spring_app_annotations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
// @ComponentScan("com.annote_practice.spring_app_annotations")
@PropertySource("classpath:strength.properties")
public class StrengthConfig {
	
	// define dep bean, method here must be the bean ID
	@Bean
	public FortuneService badFortuneService() {
		return new BadFortuneService();
	}
	// define coach bean which must consume dependency method
	@Bean
	public Coach swimCoach () {
		return new SwimCoach(badFortuneService());
	}
}
