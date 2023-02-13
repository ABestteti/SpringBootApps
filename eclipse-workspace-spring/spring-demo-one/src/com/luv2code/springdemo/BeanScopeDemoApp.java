package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {

	public static void main(String[] args) {
		// load spring configuration file
		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");
		
		// retrieve bean from spring container
		Coach theCoach = context.getBean("myCoach", Coach.class);
		Coach alphaCoach = context.getBean("myCoach", Coach.class);
		
		// check if the objects are the same - point to the same address
		boolean result = (theCoach == alphaCoach);
		
		// print out results
		System.out.println("\nPointing to the same object...: " + result);
		
		System.out.println("\nMemory location for theCoach..: " + theCoach.toString());
		
		System.out.println("\nMemory location for alphaCoach: " + alphaCoach.toString() + "\n");
		
		// close the context
		context.close();
		
	}

}
