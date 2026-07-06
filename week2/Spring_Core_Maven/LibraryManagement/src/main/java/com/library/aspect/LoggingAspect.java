package com.library.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Around("execution(* com.library.service.BookService.*(..))")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();

        System.out.println("[AOP-BEFORE] Executing method: " + joinPoint.getSignature().toShortString());
        
        // Proceed with the actual method execution
        Object proceed = joinPoint.proceed();

        long executionTime = System.currentTimeMillis() - start;
        System.out.println("[AOP-AFTER] Completed method: " + joinPoint.getSignature().toShortString() + " in " + executionTime + " ms");
        
        return proceed;
    }
}
