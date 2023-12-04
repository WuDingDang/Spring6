package com.wdd.spring6.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;

public class User implements BeanNameAware,BeanClassLoaderAware,BeanFactoryAware, InitializingBean,DisposableBean {
    private String name;

    public void setName(String name) {
        System.out.println("第二步：给对象属性赋值");
        this.name = name;
    }

    public User() {
        System.out.println("第一步：无参构造方法执行");
    }

    public void initBean(){
        System.out.println("第四步：初始化Bean");
    }

    public void destroyBean(){
        System.out.println("第七步：销毁Bean");
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        System.out.println("Bean的这个类的加载器是"+classLoader);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("生产这个Bean的工厂对象是"+beanFactory);
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("这个bean的名字是"+name);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean 的 afterPropertiesSet执行");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("DisposableBean 的 destroy执行");
    }
}
