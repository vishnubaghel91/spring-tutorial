package com.example.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect

public class OperationAspect {

    /*@Before("operationExceution()")
    public void beforeOperationExecution(JoinPoint joinPoint){
        System.out.println(joinPoint.getSignature() + ": start");
    }*/

    /*@After("operationExceution()")
    public void afterOperationExecution(JoinPoint joinPoint){
        System.out.println(joinPoint.getSignature() + ": end");
    }*/

    /*@AfterThrowing(pointcut= "operationExceution()", throwing = "ex")
    public void afterThrowingOperationExecution(JoinPoint joinPoint, Throwable ex){
        System.out.println(joinPoint.getSignature() + "errr="+ ex);
    }*/
    /*@AfterReturning("operationExceution()")
    public void afterReturningOperationExecution(JoinPoint joinPoint){
        System.out.println(joinPoint.getSignature() +"Return method"+ ": end");
    }*/

    @Around("operationExceution()")
    public Object afterThrowingOperationExecution(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        //before
        System.out.println("before");
        Object obj = null;
        try {
           obj = proceedingJoinPoint.proceed();
        } catch (Throwable e) {
            //after thrwo
            System.out.println("after throw");
           throw e;
        }
        // after
        System.out.println("after");
        return obj;
    }

    @Pointcut("execution(* com.example.aop.Operation.*(..))")
    public void operationExceution(){

    }

}
