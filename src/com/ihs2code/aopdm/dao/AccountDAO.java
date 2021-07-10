package com.ihs2code.aopdm.dao;

import org.springframework.stereotype.Component;

@Component
public class AccountDAO {

	public void addAccount() {
		
		System.out.println(getClass() + ": DOING MY DATABASE WORK: ADDING AN ACCOUNT");
	}
}
