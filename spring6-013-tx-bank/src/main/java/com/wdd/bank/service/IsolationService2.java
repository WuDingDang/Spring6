package com.wdd.bank.service;

import com.wdd.bank.dao.AccountDao;
import com.wdd.bank.pojo.Account;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("i2")
public class IsolationService2 {

    @Resource(name = "accountDao")
    AccountDao accountDao;

    //负责插入
    @Transactional(timeout = 10)   //设置超时时间10s
    public void save(Account act){

        //睡眠一会 20s后才提交事务
        try {
            Thread.sleep(1000*20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        accountDao.insert(act);
    }
}
