package com.wdd.spring6.service;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration   //代替spring.xml文件
@ComponentScan({"com.wdd.spring6.service"})    //组件扫描
@EnableAspectJAutoProxy(proxyTargetClass = true)    //开启aspectj的自动代理
public class Spring6Config {
}
