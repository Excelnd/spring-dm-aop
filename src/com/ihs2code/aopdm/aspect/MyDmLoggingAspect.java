package com.ihs2code.aopdm.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.ihs2code.aopdm.Account;

@Aspect
@Component
@Order(2)
public class MyDmLoggingAspect {
	
	// add a new device for @AfterReturning on the findAccounts method
	@AfterReturning(
			pointcut="execution(* com.ihs2code.aopdm.dao.AccountDAO.findAccounts(..))",
			returning="result")
	public void afterReturningFindAccountsAdvice(
					JoinPoint theJoinPoint, List<Account> result) {
		
		// print out which method are advising on
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n==========>>>>> Executing @AfterReturning on method: " + method);
		
		// print out the results of the method call
		System.out.println("\n==========>>>>> result is: " + result);
		
		// post-process the data ... modification
		
		// convert the account names to uppercase
		converAccountNamesToUpperCase(result);
		
		System.out.println("\n=======>>>>> result is: " + result);
		
	}
		
	private void converAccountNamesToUpperCase(List<Account> result) {
		// loop through accounts
		
		for (Account tempAccount: result) {
			
			// get uppercase name
			String theUpperName = tempAccount.getName().toUpperCase();
			
			// update the name on the account
			tempAccount.setName(theUpperName);
		}
		
	}

	@Before("com.ihs2code.aopdm.aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
		
		System.out.println("\n============>> Executing @Before advice on addAccount() method");
		
		// display the method signature
		MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();
		
		System.out.println("Mehtod: " + methodSig);
		
		// display method arguments

		
		// get args
		Object[] args = theJoinPoint.getArgs();

		// loop through args
		for (Object tempArg : args) {
			System.out.println(tempArg);

			if (tempArg instanceof Account) {
				
				// downcast and print Account specific stuff
				Account theAccount = (Account) tempArg;
				
				System.out.println("account name: " + theAccount.getName());
				System.out.println("account name: " + theAccount.getLevel());
				
			}
		}

	}
	
}
