package com.springappone;

public class MyApp {

	public static void main(String[] args) {
		// make object
		Coach coach = new TrackCoach();
		// use obj
		System.out.print(coach.getDailyTraining());
		
		// Currently this is not configurable and not using beans or Spring, expansions in SpringAppMain.java
	}

}
