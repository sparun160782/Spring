package com.config;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class LoggingAspect {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Pointcut("within(com.bookshop.entity..*) || within(com.service..*)")
	public void loggingPointCut(){
		
	}
	
	 @Around("loggingPointCut()")
	    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
	        if (log.isDebugEnabled()) {
	            log.debug("Enter: {}.{}() with argument[s] = {}", joinPoint.getSignature().getDeclaringTypeName(),
	                joinPoint.getSignature().getName(), Arrays.toString(joinPoint.getArgs()));
	        }
	        try {
	            Object result = joinPoint.proceed();
	            if (log.isDebugEnabled()) {
	                log.debug("Exit: {}.{}() with result = {}", joinPoint.getSignature().getDeclaringTypeName(),
	                    joinPoint.getSignature().getName(), result);
	            }
	            return result;
	        } catch (IllegalArgumentException e) {
	            log.error("Illegal argument: {} in {}.{}()", Arrays.toString(joinPoint.getArgs()),
	                    joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName());

	            throw e;
	        }
	    }

}
