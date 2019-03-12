package com.student.fhms.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.jboss.logging.Logger;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class FHMSLoggingAspect {
	
	private Logger logger=Logger.getLogger(FHMSLoggingAspect.class.getName());
	
	//Setup pointcut declaration for controller pckage
	@Pointcut("execution(* com.student.fhms.controller.*.*(..))")
	public void forControllerPackage(){}
	
	//Setup pointcut declaration for service package
	@Pointcut("execution(* com.student.fhms.service.*.*(..))")
	public void forServicePackage(){}
	
	//setup Pointcut for DAO Package
	@Pointcut("execution(* com.student.fhms.dao.*.*(..))")
	public void forDaoPackage(){}
	@Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
	public void forAppFlow(){}
	
	// Add Before Advice
	@Before("forAppFlow()")
	public void beforeAdvice(JoinPoint theJoinPoint){
		// display method we are calling
		String method=theJoinPoint.getSignature().toShortString();
	//	logger.info("---------------------------------> In Befor call method :"+method);
		Object[] args=theJoinPoint.getArgs();
		for(Object obj:args){
	//		logger.info("--------------------------------->  arguments :"+obj);
		}
		
		
	}
	@AfterReturning(pointcut="forAppFlow()",returning="result")
	public void afterReturningAspect(JoinPoint theJoinPoint,Object result){
		// display method we are returning form
		String method=theJoinPoint.getSignature().toShortString();
	//	logger.info("---------------------------------> In AfterReturning method :"+method);
		// display data returned;
	//	logger.info("---------------------------------> data returned :"+result);
	}

}
