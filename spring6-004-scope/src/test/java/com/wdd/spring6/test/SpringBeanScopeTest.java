package com.wdd.spring6.test;

import com.wdd.spring6.bean.SpringBean;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringBeanScopeTest {
    @Test
    public void testBeanScope(){
        /**
         * 1.Spring默认情况下如何管理bean
         *      默认情况下Bean是单例的 singleton
         *      在Spring上下文初始化的时候实例化
         *      每一次调用getBean方法的时候，都返回的是单例对象
         * 2.当将bean的scope属性设置为prototype时：
         *      bean是多例的
         *      spring上下文初始化的时候不会初始化这些prototype的bean
         *      每一次调用getBean方法的时候，实例化该bean对象
         *      prototype （原型）
         */
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-scope.xml");
        SpringBean sb = applicationContext.getBean("sb", SpringBean.class);
        System.out.println(sb);
        SpringBean sb2 = applicationContext.getBean("sb", SpringBean.class);
        System.out.println(sb2);
    }

    @Test
    public void testThreadScope(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-scope.xml");
        SpringBean sb = applicationContext.getBean("sb", SpringBean.class);
        System.out.println(sb);
        SpringBean sb1 = applicationContext.getBean("sb", SpringBean.class);
        System.out.println(sb1);
        //启动一个新的线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                SpringBean sb2 = applicationContext.getBean("sb", SpringBean.class);
                System.out.println(sb2);
                SpringBean sb3 = applicationContext.getBean("sb", SpringBean.class);
                System.out.println(sb3);
            }
        }).start();
    }

}
