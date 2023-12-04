package org.wdd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.wdd.dao.OrderDao;

@Service
public class OrderService {
    //@Autowired 注解使用时，不需要指定任何属性，直接使用
    //@Autowired的作用：根据类型进行自动装配
//    @Autowired
//    private OrderDao orderDao;

    @Autowired
    @Qualifier("orderDaoImplForOracle")
    private OrderDao orderDao;
    public void generate(){
        orderDao.insert();
    }
}
