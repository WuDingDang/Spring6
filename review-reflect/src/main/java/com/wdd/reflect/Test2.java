package com.wdd.reflect;

import java.lang.reflect.Method;

public class Test2 {

    public static void main(String[] args) throws Exception{
        //使用反射机制
        //1.获取类
        Class<?> aClass = Class.forName("com.wdd.reflect.SomeService");
        //获取方法
        Method doSomeMethod = aClass.getDeclaredMethod("doSome", String.class, int.class);
        //调用方法
        //4要素：哪个对象？哪个方法？传什么参数？返回什么值？
        //obj:哪个对象
        //doSomeMethod:哪个方法
        //"李四", 250 :传什么参数
        //reValue:返回什么值
        Object obj = aClass.newInstance();
        Object reValue = doSomeMethod.invoke(obj, "李四", 250);
        System.out.println(reValue);
    }
}
