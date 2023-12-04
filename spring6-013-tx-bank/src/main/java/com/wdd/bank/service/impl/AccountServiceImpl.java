package com.wdd.bank.service.impl;

import com.wdd.bank.dao.AccountDao;
import com.wdd.bank.pojo.Account;
import com.wdd.bank.service.AccountService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("accountService")
//@Transactional
public class AccountServiceImpl implements AccountService {
    @Resource(name = "accountDao")
    private AccountDao accountDao;

    //控制事务，因为在这个方法里要完成所有的转账业务
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void transfer(String fromActno, String toActno, double money) {
        //查询转出账户的余额是否充足
        Account fromAct = accountDao.selectByActno(fromActno);
        if(fromAct.getBalance() < money){
            throw new RuntimeException("余额不足");
        }
        //余额充足
        Account toAct = accountDao.selectByActno(toActno);
        //将内存中两个对象的余额先修改
        fromAct.setBalance(fromAct.getBalance() - money);
        toAct.setBalance(toAct.getBalance() + money);
        //数据库更新
        int count = accountDao.update(fromAct);

        //模拟异常
//        String s = null;
//        s.toString();

        count += accountDao.update(toAct);
        if(count != 2){
            throw new RuntimeException("转账失败，联系银行！");
        }

    }

    @Resource(name = "accountService2")
    private AccountService accountService;

    @Override
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT)
    public void save(Account act) {
        //调用dao的insert方法
        accountDao.insert(act);
        //创建账户对象
        Account act2 = new Account("act-4",1000.0);
       // try{
            accountService.save(act2);
//        }catch (Exception e){
//
//        }

    }
}
