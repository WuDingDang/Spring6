package com.wdd.reflect;

public class Test {
    public static void main(String[] args) {
        //不使用反射机制，调用方法
        /**
         * 分析：调用一个方法，有几要素？
         * 1.调用哪个对象
         * 2.调用哪个方法
         * 3.调用方法的时候传什么参数
         * 4.方法执行结束后的返回结果
         */
        SomeService someService = new SomeService();
        someService.doSome();
        String s1 = someService.doSome("张三");
        String s2 = someService.doSome("李四", 250);
    }
}
