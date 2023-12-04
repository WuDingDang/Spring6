package com.wdd.spring6.test;

import com.wdd.spring6.bean.Student;
import com.wdd.spring6.bean.User;
import org.junit.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifeCycleTest {
    @Test
    public void testBeanLifeCycleFive(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        User user = applicationContext.getBean("user", User.class);
        System.out.println("第六步：使用bean");
        //注意：必须手动关闭spring容器，这样spring容器才会销毁bean
        ClassPathXmlApplicationContext classPathXmlApplicationContext = (ClassPathXmlApplicationContext) applicationContext;
        classPathXmlApplicationContext.close();

    }

    @Test
    public void testRegisterBean(){
        //自己new的对象
        Student student = new Student();
        System.out.println(student);
        //将自己new的对象纳入spring管理
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        factory.registerSingleton("student",student);
        //从spring容器中获取bean
        Student student1 = factory.getBean("student", Student.class);
        System.out.println(student1);
    }
}
