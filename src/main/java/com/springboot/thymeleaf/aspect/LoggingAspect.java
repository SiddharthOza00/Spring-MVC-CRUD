package com.springboot.thymeleaf.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

public class LoggingAspect {

  // setup the logger
  private Logger myLogger = Logger.getLogger(getClass().getName());

  // setup pointcut expressions
  @Pointcut("execution(* com.springboot.thymeleaf.controller.*.*(..))")
  private void forControllerPackage() {}

  @Pointcut("execution(* com.springboot.thymeleaf.service.*.*(..))")
  private void forServicePackage() {}

  @Pointcut("execution(* com.springboot.thymeleaf.dao.*.*(..))")
  private void forDaoPackage() {}

  @Pointcut("forDaoPackage() || forControllerPackage() || forServicePackage()")
  private void forAppFlow() {}

  @Before("forAppFlow()")
  private void before(JoinPoint theJoinPoint) {

    // display the method we are calling
    String theMethod = theJoinPoint.getSignature().toShortString();
    myLogger.info("\n=======>> in @Before: calling method: " + theMethod);

    // display the arguments in the method

    // get the arguments
    Object[] args = theJoinPoint.getArgs();

    // loop through and display the arguments
    for(Object arg : args ) {
      myLogger.info("=======>> argument: " + arg);
    }
  }

  @AfterReturning(
      pointcut = "forAppFlow()",
      returning = "theResult")
  private void afterReturning(JoinPoint theJoinPoint, Object theResult) {

    // display the method we are returning from
    String theMethod = theJoinPoint.getSignature().toShortString();
    myLogger.info("\n=======>> in @After: calling method: " + theMethod);

    // display data returned
    myLogger.info("=======>> result: " + theResult);
  }

}
