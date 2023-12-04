package com.wdd.spring6.service;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect   //切面类需要使用@Aspect注解进行标注
@Order(2)
public class LogAspect {   //切面 = 通知+切点

    //定义通用的切点表达式
    @Pointcut("execution(* com.wdd.spring6.service..*(..))")
    public void 通用切点(){
        //这个方法只是一个标记，方法名随意，方法体中也不需要任何代码
    }

    //通知就是增强，就是具体要编写的代码
    //这里通知Advice以方法的形式出现，因为方法中可以写代码
    //前置通知
    //@Before(切点表达式)注解标注的方法就是前置通知
    @Before("通用切点()")
    public  void beforeAdvice(JoinPoint joinPoint){
        System.out.println("前置通知");
        //获取目标方法的方法名
        System.out.println("方法名："+joinPoint.getSignature().getName());
    }

    //后置通知
    @AfterReturning("execution(* com.wdd.spring6.service..*(..))")
    public void afterReturningAdvice(){
        System.out.println("后置通知");
    }
    //环绕通知 ：在前置通知之前，在后置通知之后
    @Around("execution(* com.wdd.spring6.service..*(..))")
    public void aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("前环绕");
        //执行目标
        joinPoint.proceed();   //执行目标
        System.out.println("后环绕");
    }
    //异常通知
    @AfterThrowing ("execution(* com.wdd.spring6.service..*(..))")
    public void afterThrowingAdvice(){
        System.out.println("异常通知");
    }
    //最终通知
    @After("execution(* com.wdd.spring6.service..*(..))")
    public void afterAdvice(){
        System.out.println("最终通知");
    }
}
