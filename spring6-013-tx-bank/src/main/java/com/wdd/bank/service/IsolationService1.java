package com.wdd.bank.service;

import com.wdd.bank.dao.AccountDao;
import com.wdd.bank.pojo.Account;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service("i1")
public class IsolationService1 {

    @Resource(name = "accountDao")
    AccountDao accountDao;

    //负责查询
    //当前事务可以读取到别的事务没有提交的数据
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public void getByActno(String actno){
        Account account = accountDao.selectByActno(actno);
        System.out.println("查询到的账户信息:"+account);
    }
}
