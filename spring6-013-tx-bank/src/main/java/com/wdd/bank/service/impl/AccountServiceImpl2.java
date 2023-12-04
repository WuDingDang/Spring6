package com.wdd.bank.service.impl;

import com.wdd.bank.dao.AccountDao;
import com.wdd.bank.pojo.Account;
import com.wdd.bank.service.AccountService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.*;

@Service("accountService2")
public class AccountServiceImpl2 implements AccountService {
    @Resource(name = "accountDao")
    private AccountDao accountDao;
    @Override
    public void transfer(String fromActno, String toActno, double money) {

    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void save(Account act) {
        accountDao.insert(act);
        //模拟异常
        Spring s =null;
        s.toString();
    }
}
