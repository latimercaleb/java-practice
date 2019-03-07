package com.annote_practice.spring_app_annotations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:App7.properties")
public class App7Config {
	@Bean
	public App7Service app7Service () {
		return new App7Service();
	}
	
	@Bean
	public App7Coach app7Coach() {
		return new App7Coach(app7Service());
	}
}
