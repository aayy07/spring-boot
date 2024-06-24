package com.javademo.javademo.logging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Pointcut("execution(* com.javademo.javademo.controller..*(..))")
    public void controllerMethods() {}

    @Before("controllerMethods()")
    public void logBeforeMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        logger.info("Method execution started: {}", methodName);
    }

    @After("controllerMethods()")
    public void logAfterMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        logger.info("Method execution finished: {}", methodName);
    }

    @AfterReturning(pointcut = "controllerMethods()", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        String methodName = joinPoint.getSignature().getName();
        logger.info("Method returned with value: {} from {}", result, methodName);
    }

    @AfterThrowing(pointcut = "controllerMethods()", throwing = "error")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable error) {
        String methodName = joinPoint.getSignature().getName();
        logger.error("Method threw an error: {} from {}", error, methodName);
    }

    @Around("controllerMethods()")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        logger.info("Method execution started (Around): {}", methodName);
        Object result = joinPoint.proceed();
        logger.info("Method execution finished (Around): {}", methodName);
        return result;
    }
}

