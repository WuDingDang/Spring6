package com.wdd.proxy.client;

import com.wdd.proxy.service.OrderService;
import com.wdd.proxy.service.OrderServiceImpl;
import com.wdd.proxy.service.OrderServiceProxy;

public class Test {
    public static void main(String[] args) {
        /*
        OrderService orderService = new OrderServiceImpl();
        orderService.generate();
        orderService.modify();
        orderService.detail();

         */

        //创建目标对象
        OrderService target = new OrderServiceImpl();
        //创建代理对象
        OrderService proxy = new OrderServiceProxy(target);
        //调用代理对象的代理方法
        proxy.generate();
        proxy.modify();
        proxy.detail();
    }
}
