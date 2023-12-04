package com.wdd.proxy.util;

import com.wdd.proxy.service.TimeerInvocationHandler;

import java.lang.reflect.Proxy;

public class ProxyUtil {
    /**
     * 封装一个工具方法，可以通过这个方法获取代理对象
     */
    public static Object newProxyInstance(Object target){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),new TimeerInvocationHandler(target));
    }
}
