package com.luv2code.springdemo;

public class BaseballCoach implements Coach {
	
	// Define a private field for for the dependency
	private FortuneService fortuneService;
	
	//Define a constructor for dependency injection
	public BaseballCoach(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		return "Spend 30 minutes on batting practice.";
	}

	@Override
	public String getDailyFortune() {
		
		// use 	my fortuneService to get the fortune
		return fortuneService.getFortune();
	}

}
