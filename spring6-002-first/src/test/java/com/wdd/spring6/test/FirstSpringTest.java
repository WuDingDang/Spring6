package com.wdd.spring6.test;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FirstSpringTest {
    @Test
    public void testFirstSpringCode(){
        //第一步：获取Spring容器对象
        //ApplicationContext 翻译为应用上下文，其实就是Spring容器
        //ApplicationContext是一个接口，有很多实现类，其中有一个实现类叫ClassPathXmlApplicationContext
        //ClassPathXmlApplicationContext  专门从类路径当中加载Spring配置文件 的一个Spring上下文对象
        //这行代码只要执行，就相当于启动了Spring容器，解析spring.xml文件，并且实例化所有bean对象，放到容器当中
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        //第二步：根据bean的id从spring容器中获取对象
        Object userBean = applicationContext.getBean("userBean");
        System.out.println(userBean);

      //  Date nowtime = (Date)applicationContext.getBean("nowtime");
        //不想强制类型转换，可以使用以下代码(通过第二个参数，指定返回的bean类型)
        Date nowtime = applicationContext.getBean("nowtime", Date.class);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
        String stringNoeTime = sdf.format(nowtime);
        System.out.println(stringNoeTime);

        //自己如何使用log4j2记录日志信息
        //第一步：创建日志记录器对象
        //获取FirstSpringTest类的日志记录器对象
        Logger logger = LoggerFactory.getLogger(FirstSpringTest.class);
        //第二步：记录日志 根据不同日志级别输出日志
        logger.info("信息info");
        logger.debug("信息debug");
        logger.error("信息error");


    }
}
