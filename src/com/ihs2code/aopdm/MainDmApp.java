package com.ihs2code.aopdm;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ihs2code.aopdm.dao.AccountDAO;
import com.ihs2code.aopdm.dao.MembershipDAO;

public class MainDmApp {

	public static void main(String[] args) {
		
		// read spring config java class
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DmConfig.class);
		
		// get the bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		// get membership bean from spring container
		MembershipDAO theMembershipDAO =
				context.getBean("membershipDAO", MembershipDAO.class);
		
		// call the business method
		theAccountDAO.addAccount();
		
		// call the membership business method
		theMembershipDAO.addSillyMember();
		
		// close the context
		context.close();

	}

}
