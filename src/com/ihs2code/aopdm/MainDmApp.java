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
		Account myAccount = new Account();
		myAccount.setName("Alan");
		myAccount.setLevel("Gold");
		
		theAccountDAO.addAccount(myAccount, true);
		theAccountDAO.doWork();
		
		// call the account DAO getter/setter methods
		theAccountDAO.setName("foobar");
		theAccountDAO.setServiceCode("silver");
		
		String name = theAccountDAO.getName();
		String code = theAccountDAO.getServiceCode();
		
		// call the membership business method
		theMembershipDAO.addSillyMember();
		theMembershipDAO.goToSleep();
		
		// close the context
		context.close();

	}

}
