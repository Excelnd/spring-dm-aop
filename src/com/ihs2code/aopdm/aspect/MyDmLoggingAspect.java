package com.ihs2code.aopdm.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDmLoggingAspect {

	// related advices for logging
	
	// start with an @Before advice
	
	@Pointcut("execution(* com.ihs2code.aopdm.dao.*.*(..))")
	private void forDaoPackage() {}
	
	
	@Before("forDaoPackage()")
	public void beforeAddAccountAdvice() {
		
		System.out.println("\n============>> Executing @Before advice on addAccount() method ");
	}
}
