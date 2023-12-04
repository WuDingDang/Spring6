package com.wdd.spring6.service;

import org.springframework.stereotype.Service;

@Service
public class AccountService {   //目标对象
    //转账业务方法
    public void transfer(){    //目标方法
        System.out.println("银行账户正在完成转账操作。。。");
    }

    //取款业务方法
    public void withdraw(){    //目标方法
        System.out.println("正在取款，请稍后。。。");
    }
}
