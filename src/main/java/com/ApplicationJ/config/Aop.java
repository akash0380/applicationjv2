package com.ApplicationJ.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.ApplicationJ.utility.SupportUtility;

@Aspect
@Component
public class Aop {

	@Before("execution(* com.ApplicationJ.controller.*.*(..)) || execution(* com.ApplicationJ.dao..*(..)) || execution(* com.ApplicationJ.service..*(..)) || execution(* com.ApplicationJ.utility..*(..))")
	public void logBefore(JoinPoint joinPoint) {
		SupportUtility.logger.debug("BeforeExecution: " + joinPoint.getSignature().getDeclaringTypeName()
				+" "+ joinPoint.getSignature().getName() + "()");
	}

	@After("execution(* com.ApplicationJ.controller.*.*(..)) || execution(* com.ApplicationJ.dao..*(..)) || execution(* com.ApplicationJ.service..*(..)) || execution(* com.ApplicationJ.utility..*(..))")
	public void logAfter(JoinPoint joinPoint) {
		SupportUtility.logger.debug("AfterExecution: " + joinPoint.getSignature().getDeclaringTypeName()
				+" "+ joinPoint.getSignature().getName() + "()");
	}

}
