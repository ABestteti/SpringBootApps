package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifeCycleDemoApp {

	public static void main(String[] args) {
		// load spring configuration file
		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext("beanLifeCycle-applicationContext.xml");
		
		// retrieve bean from spring container
		TrackCoach theCoach = context.getBean("myCoach", TrackCoach.class);

		System.out.println(theCoach.getDailyWorkout());
		
        // On prototype scope the destroy-method is not called. Then, it is necessary
		// to customize the prototype scope in case it is needed to call the destroy-method.
		
		// close the context
		context.close();
		
	}

}
