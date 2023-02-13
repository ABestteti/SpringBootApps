package com.luv2code.springdemo;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {

	// create a array of strings
	private String[] data = {
			"Beware of the wolf in sheep's clothing.",
			"Diligence is mother of good luck.",
			"The journey is the reward."
	};
	
	// create a random number generator
	private Random myRandom = new Random();
	
	@Override
	public String getFortunate() {
		// pick a random string from the array
		int index = myRandom.nextInt(data.length);
		
		return data[index];
	}

}
