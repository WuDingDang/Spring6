package com.wdd.spring6.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * 日志Bean后处理器
 */
public class LogBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("第三步：执行Bean后处理器的before方法");
        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }

    /*
    方法有两个参数： bean：刚创建的bean对象  beanName：bean的名字
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("第五步：执行Bean后处理器的before方法");
        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }
}
