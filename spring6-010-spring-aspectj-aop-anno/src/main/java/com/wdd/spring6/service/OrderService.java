package com.wdd.spring6.service;

import org.springframework.stereotype.Service;

@Service
public class OrderService {  //目标方法
    public void generate(){   //目标方法
        System.out.println("生成订单...");
//        if(1==1){
//            throw new RuntimeException("运行时异常");
//        }
    }
}
