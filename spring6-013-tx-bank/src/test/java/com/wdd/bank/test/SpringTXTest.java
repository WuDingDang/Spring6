package com.wdd.bank.test;

import com.wdd.bank.Spring6Config;
import com.wdd.bank.pojo.Account;
import com.wdd.bank.service.AccountService;
import com.wdd.bank.service.IsolationService1;
import com.wdd.bank.service.IsolationService2;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class SpringTXTest {
    @Test
    public void testSpringTx(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        AccountService accountService = applicationContext.getBean("accountService", AccountService.class);

        try{
            accountService.transfer("act-001","act-002",10000);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void testPropagation(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        AccountService accountService = applicationContext.getBean("accountService", AccountService.class);
        Account account = new Account("act-003",1000.0);
        accountService.save(account);
    }

    @Test
    public void testIsolation1(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        IsolationService1 i1 = applicationContext.getBean("i1", IsolationService1.class);
        i1.getByActno("act-004");
    }

    @Test
    public void testIsolation2(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        IsolationService2 i2 = applicationContext.getBean("i2", IsolationService2.class);
        Account account = new Account("act-004",1000.0);
        i2.save(account);
    }

    @Test
    public void testNoXml(){
        ApplicationContext applicationContext= new AnnotationConfigApplicationContext(Spring6Config.class);
        AccountService accountService = applicationContext.getBean("accountService", AccountService.class);

        try{
            accountService.transfer("act-001","act-002",10000);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
