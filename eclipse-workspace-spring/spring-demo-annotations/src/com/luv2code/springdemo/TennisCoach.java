package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class TennisCoach implements Coach {

	@Value("${foo.email}")
	private String email;
	    
	@Value("${foo.team}")
	private String team;

	@Autowired
	@Qualifier("randomFortuneService")
	private FortuneService fortuneService;

//	 @Autowired
//	public TennisCoach(FortuneService fortuneService) {
//		this.fortuneService = fortuneService;
//	}
	
	// define a default constructor
	public TennisCoach() {
		System.out.println(">> TennisCoach: Inside default constructor");
	}

	@Override
	public String getDailyWorkout() {
		
		return "Practice you backhand volley. Check how to with " + email;
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortunate();
	}

	public FortuneService getFortuneService() {
		return fortuneService;
	}

//	@Autowired
//	public void doSomeCrazyStuff(FortuneService fortuneService) {
//		System.out.println(">> TennisCoach: Inside doSomeCrazyStuff() method.");
//		this.fortuneService = fortuneService;
//	}

}
