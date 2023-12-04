package com.wdd.spring6.test;

import com.sun.nio.sctp.ShutdownNotification;
import com.wdd.spring6.bean.Husband;
import com.wdd.spring6.bean.Wife;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CircularDendencyTest {
    @Test
    public void testCD(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        Husband husband = applicationContext.getBean("husbandBean", Husband.class);
        System.out.println(husband);
        Wife wife = applicationContext.getBean("wifeBean", Wife.class);
        System.out.println(wife);
    }

    @Test
    public void testCD2(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring2.xml");
        Husband husband = applicationContext.getBean("h", Husband.class);
        System.out.println(husband);
        Wife wife = applicationContext.getBean("w", Wife.class);
        System.out.println(wife);
    }
}
