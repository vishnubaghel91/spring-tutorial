package com.example.spring.tutorial.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class EmployeeServiceAspect {

//    @Before("empServiceExecution()")
//    public void beforeEmpServiceExecution(JoinPoint joinPoint) {
//        System.out.println(joinPoint.getSignature() + ": start");
//    }
//
//    @After("empServiceExecution()")
//    public void afterEmpServiceExecution(JoinPoint joinPoint) {
//        System.out.println(joinPoint.getSignature() + ": end");
//    }

//    @AfterThrowing("empServiceExecution()")
//    public void afterThrowingEmpServiceExecution(JoinPoint joinPoint) {
//        System.out.println(joinPoint.getSignature() + ": end");
//    }
//
//    @AfterReturning("empServiceExecution()")
//    public void afterReturningEmpServiceExecution(JoinPoint joinPoint) {
//        System.out.println(joinPoint.getSignature() + ": end");
//    }


    @Around("empServiceExecution()")
    public Object aroundEmpServiceExecution(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        // before
        System.out.println(proceedingJoinPoint.getSignature() + ": start");
        Object obj;
        try {
            obj = proceedingJoinPoint.proceed();
        } catch (Throwable e) {
            // after throwing
            System.out.println(proceedingJoinPoint.getSignature() + e.getMessage());
            throw e;
        }
        // after/ after returning
        System.out.println(proceedingJoinPoint.getSignature() + ": end");
        return obj;

    }

    @Pointcut ("execution(* com.example.spring.tutorial.service.EmployeeService.*(..))")
    public void empServiceExecution() {}


}
