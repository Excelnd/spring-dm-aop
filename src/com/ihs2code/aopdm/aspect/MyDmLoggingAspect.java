package com.ihs2code.aopdm.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyDmLoggingAspect {
	
	@Before("com.ihs2code.aopdm.aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
		
		System.out.println("\n============>> Executing @Before advice on addAccount() method");
		
		// display the method signature
		
		// display method arguments
		
	}
	
}
