package com.wdd.bank.dao;

import com.wdd.bank.pojo.Account;

/**
 * 专门负责账户信息的CRUD操作
 * DAO中只执行SQL语句，没有业务逻辑
 *
 */
public interface AccountDao {
    /**
     * 根据账号查询账户信息
     * @param actno
     * @return
     */
    Account selectByActno(String actno);

    /**
     * 更新账户信息
     * @param act
     * @return
     */
    int update(Account act);

}
