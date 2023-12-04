package com.wdd.proxy.service;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 专门负责计时的调用处理器对象
 * 在这个调用处理器中编写计时相关的增强代码
 */
public class TimeerInvocationHandler implements InvocationHandler {
    //目标对象
    private Object target;

    public TimeerInvocationHandler(Object target) {
        this.target = target;
    }

    /*
        invoke方法是JDK负责调用的，所以JDK调用这个方法时会自动传这三个参数
        可以在invoke方法里直接使用
        Object proxy：代理对象的引用，使用较少
        Method method：目标对象的目标方法
        Object[] args：目标方法上的实参

        在invoke方法执行过程中，使用method调用目标对象的目标方法
         */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("invoke()....");
        long begin = System.currentTimeMillis();
        //调用目标对象的目标方法
        //方法四要素：哪个对象？哪个方法？传什么参数？返回什么值？
        Object retValue = method.invoke(target, args);
        long end = System.currentTimeMillis();
        System.out.println("耗时"+(end - begin) + "毫秒");
        //注意：如果代理对象调用代理方法后，需要返回结果，invoke方法必须将目标对象的目标方法执行结果继续返回
        return retValue;
    }
}
