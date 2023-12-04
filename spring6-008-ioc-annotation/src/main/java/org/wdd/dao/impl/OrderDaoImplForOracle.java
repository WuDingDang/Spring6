package org.wdd.dao.impl;

import org.springframework.stereotype.Repository;
import org.wdd.dao.OrderDao;
@Repository
public class OrderDaoImplForOracle implements OrderDao {

    @Override
    public void insert() {
        System.out.println("oracle正在保存订单信息，，，");
    }
}
