package com.wdd.spring6.bean3;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Component
public class Product {
    /*
    @Value("hhh")
    private String name;
    @Value("30")
    private int age;
     */
    private String name;
    private int age;

    /*
    // @Value也可以使用在方法上
    @Value("kkk")
    public void setName(String name) {
        this.name = name;
    }
    @Value("11")
    public void setAge(int age) {
        this.age = age;
    }

     */

    public Product(@Value("lll") String name, @Value("88") int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
