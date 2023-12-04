package com.wdd.spring6.service;

import org.springframework.stereotype.Service;

@Service
public class UserService {  //目标类
    public void login(){   //目标方法
        System.out.println("系统正在进行身份认证...");
    }

    public void logout(){
        System.out.println("退出系统...");
    }
}
