package com.ihs2code.aopdm;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ihs2code.aopdm.service.TrafficFortuneService;

public class AroundWithLoggerDmApp {
	
	private static Logger myLogger = 
					Logger.getLogger(AroundWithLoggerDmApp.class.getName());

	public static void main(String[] args) {
		
		// read spring config java class
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DmConfig.class);
		
		// get the bean from spring container
		TrafficFortuneService theFortuneService = 
				context.getBean("trafficFortuneService", TrafficFortuneService.class);
		
		myLogger.info("\nMain Program: AroundDemoApp");
		
		myLogger.info("Calling getFortune");
		
		String data = theFortuneService.getFortune();
		
		myLogger.info("\nMy Fortune is: " + data);

		myLogger.info("Finished");
		
		// close the context
		context.close();

	}

}

