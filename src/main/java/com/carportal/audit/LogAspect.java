package com.carportal.audit;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

//@Aspect
@Component("LoggingAspect")
public class LogAspect {

	Logger log = LoggerFactory.getLogger(LogAspect.class);

	/*
	 * @Pointcut(value = "com.carportal.controller.*.*.*(..))") public void
	 * myPointCut() {
	 * 
	 * }
	 * 
	 * @Around("myPointCut()") public Object applicationLogger(ProceedingJoinPoint
	 * pjp) throws Throwable { ObjectMapper mapper = new ObjectMapper(); String
	 * methodName = pjp.getSignature().getName(); String className =
	 * pjp.getTarget().getClass().toString(); Object[] array = pjp.getArgs();
	 * log.info("Method Invoked: " + className + " : " + methodName + "()" +
	 * "Arguments: " + mapper.writeValueAsString(array)); Object object =
	 * pjp.proceed(); log.info(className + " : " + methodName + "()" + "Response: "
	 * + mapper.writeValueAsString(array)); return object;
	 * 
	 * }
	 */

}
