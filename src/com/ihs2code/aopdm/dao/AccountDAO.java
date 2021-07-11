package com.ihs2code.aopdm.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.ihs2code.aopdm.Account;

@Component
public class AccountDAO {
	
	private String name;
	private String serviceCode;

	public List<Account> findAccount() {
		
		List<Account> myAccounts = new ArrayList<>();
		
		// create a sample accounts
		Account temp1 = new Account("James", "Silver");
		Account temp2 = new Account("Madhu", "Platinum");
		Account temp3 = new Account("Lary", "Gold");
		
		// add them to accounts list
		myAccounts.add(temp1);
		myAccounts.add(temp2);
		myAccounts.add(temp3);
		
		return myAccounts;		
	}
	
	public void addAccount(Account theAccount, boolean vipFlag) {
		
		System.out.println(getClass() + ": DOING MY DATABASE WORK: ADDING AN ACCOUNT");
	}
	
	public boolean doWork() {
		
		System.out.println(getClass() + ": doWork()");
		return false;
	}
	
	public String getName() {
		System.out.println(getClass() + ": in getName()");
		return name;
	}

	public void setName(String name) {
		System.out.println(getClass() + ": in setName()");
		this.name = name;
	}

	public String getServiceCode() {
		System.out.println(getClass() + ": in getServiceCode()");
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println(getClass() + ": in setServiceCode()");
		this.serviceCode = serviceCode;
	}
}
