package com.wdd.spring6.service;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
public class SecurityAspect {  //安全切面
    //通知+切点
    @Before("com.wdd.spring6.service.LogAspect.通用切点()")
    public void beforeAdvice(){
        System.out.println("前置通知：安全...");
    }
}
