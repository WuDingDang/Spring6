package com.wdd.proxy.client;

import com.wdd.proxy.service.OrderService;
import com.wdd.proxy.service.OrderServiceImpl;
import com.wdd.proxy.service.TimeerInvocationHandler;
import com.wdd.proxy.util.ProxyUtil;

import java.lang.reflect.Proxy;

public class Client {
    //客户端程序
    public static void main(String[] args) {
        //创建目标对象
        OrderService target = new OrderServiceImpl();
        //创建代理对象
        /*
        1.newProxyInstance :新建代理对象
            通过调用这个方法可以创建代理对象
            本质上，这个newProxyInstance执行，做了两件事：
                第一件事：在内存中动态生成了一个代理类的字节码class
                第二件事：new对象了。通过内存中生成的代理类这个代码，实例化了代理对象
        2.newProxyInstance的三个重要参数
          1）ClassLoader loader
            类加载器
            作用：在内存中生成的字节码也是class文件，要执行也得先加载到内存中。加载类就需要类加载器，所以这里需要指定类加载器
                并且JDK要求，目标类的类加载器必须和代理类的类加载器使用同一个
          2）Class<?>[] interfaces
            代理类要实现的接口
            代理类和目标类要实现同一个接口或同一些接口，
            在内存中生成代理类的时候，代理类需要知道实现哪些接口
          3）InvocationHandler h
            调用处理器，是一个接口
            在调用处理器接口中编写的是增强的代码

            注意：代理对象和目标对象实现的接口一样，所以可以向下转型
         */
        OrderService proxy = (OrderService) ProxyUtil.newProxyInstance(target);
        //调用代理对象的代理方法
        proxy.generate();
        String name = proxy.getName();
        System.out.println(name);
    }
}
