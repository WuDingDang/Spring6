package com.wdd.spring6.bean;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class Person {
    //注入list集合
    private List<String> names;
    //注入set集合
    private Set<String> addrs;
    //注入Map集合
    private Map<Integer,String> phones;
    //注入属性类对象
    //Properties本质上也是Map集合
    //Properties的父类是HashTable，HashTable实现了Map接口
    //Properties的key和value只能是String类型
    private Properties properties;

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public void setPhones(Map<Integer, String> phones) {
        this.phones = phones;
    }

    public void setNames(List<String> names) {
        this.names = names;
    }

    public void setAddrs(Set<String> addrs) {
        this.addrs = addrs;
    }

    @Override
    public String toString() {
        return "Person{" +
                "names=" + names +
                ", addrs=" + addrs +
                ", phones=" + phones +
                ", properties=" + properties +
                '}';
    }
}
