package com.wdd.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Test3 {
    public static void main(String[] args) throws Exception{
        /*
        需求：
        已知：
        1.有一个类，类名：com.wdd.reflect.User
        2.这个类符合javabean规范。属性私有化，对外提供公开的setter和getter
        3.还知道这个类中有一个属性age
        4.属性age的类型时int

        使用反射机制调用相关方法，给User对象的age属性赋值
         */
        String className = "com.wdd.reflect.User";
        String propertyName = "age";

        //通过反射机制调用setAge(int)方法
        //获取类
        Class<?> aClass = Class.forName(className);
        //获取方法名
        String setMethodName = "set" + propertyName.toUpperCase().charAt(0) + propertyName.substring(1);
        //根据属性名获取属性类型
        Field declaredField = aClass.getDeclaredField(propertyName);
        //获取方法
        Method setMethod = aClass.getDeclaredMethod(setMethodName, declaredField.getType());
        Object obj = aClass.newInstance();
        setMethod.invoke(obj,30);
        System.out.println(obj);
    }
}
