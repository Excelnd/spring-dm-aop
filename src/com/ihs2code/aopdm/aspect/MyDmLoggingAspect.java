package com.ihs2code.aopdm.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
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
	
	@Around("execution(* com.ihs2code.aopdm.service.*.getFortune(..))")
	public Object aroundGetFortune(			
			ProceedingJoinPoint theProceedingJoinPoint) throws Throwable {
		
		// print out the method we are advising on
		String method = theProceedingJoinPoint.getSignature().toShortString();
		System.out.println("\n========>>> Executing @Around on method: "
						+ method);
		
		// get begin timestamp
		long begin = System.currentTimeMillis();
		
		// excute method
		Object result = theProceedingJoinPoint.proceed();
		
		// get end timestamp
		long end = System.currentTimeMillis();
		
		// compute duration and display it 
		long duration = end - begin;
		System.out.println("\n========>>> Duration: "+ duration / 1000.0 + " seconds");
		
		return result;
	}
	
	
	@After("execution(* com.ihs2code.aopdm.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyFindAccountsAdvice(JoinPoint theJoinPoint) {
		
		// print out the method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n========>>> Executing @After(finally) on method: "
						+ method);
	}
	
	@AfterThrowing(
			pointcut="execution(* com.ihs2code.aopdm.dao.AccountDAO.findAccounts(..))",
			throwing="theExc")
	public void afterThrowingFindAccountsAdvice(
					JoinPoint theJoinPoint, Throwable theExc) {
		
		// print out the method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n========>>> Executing @AfterThrowing on method: " + method);
		
		// log the exception
		System.out.println("\n========>>> The exception is: " + theExc);
		
	}
	
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
