package com.luv2code.springdemo;

import org.springframework.stereotype.Component;

@Component
public class HappyFortuneService implements FortuneService {

	@Override
	public String getFortunate() {
		return "Today is your lucky day!";
	}

}
