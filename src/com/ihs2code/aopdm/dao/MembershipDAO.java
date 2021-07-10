package com.ihs2code.aopdm.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

	public void addSillyMember() {
		
		System.out.println(getClass() + ": Doing Stuff: ADDING A MEMBERSHIP ACCOUNT");
	}
}
