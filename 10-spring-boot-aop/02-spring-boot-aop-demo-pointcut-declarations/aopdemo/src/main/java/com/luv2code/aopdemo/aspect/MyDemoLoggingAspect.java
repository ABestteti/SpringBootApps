package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    // this is where we add all of our related advices for logging

    @Pointcut("execution(* com.luv2code.aopdemo.dao.*.*(..))")
    private void forDoaPackage() {}

    @Before("forDoaPackage()")
    public void beforeAddAccountAdvice() {
        System.out.println("\n====>>>> Executing @Before advice on addAccount() ...");
    }
}
