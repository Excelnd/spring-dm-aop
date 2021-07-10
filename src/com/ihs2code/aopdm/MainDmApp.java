package com.ihs2code.aopdm;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ihs2code.aopdm.dao.AccountDAO;

public class MainDmApp {

	public static void main(String[] args) {
		
		// read spring config java class
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DmConfig.class);
		
		// get the bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		// call the business method
		theAccountDAO.addAccount();
		
		// retest
		System.out.println("\n let's call it again!\n");
		
		// call the business method again
		theAccountDAO.addAccount();
		
		// close the context
		context.close();

	}

}
