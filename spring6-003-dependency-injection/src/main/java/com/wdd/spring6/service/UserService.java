package com.wdd.spring6.service;

import com.wdd.spring6.dao.UserDao;
import com.wdd.spring6.dao.VipDao;

/**
 * Bean
 */
public class UserService {
    private UserDao userDao;
    //set注入，必须提供一个set方法
    //spring容器会调用这个set方法，给UserDao属性赋值

    //这个set方法是IDEA工具生成的，符合javabean规范
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    //不使用IDEA自动生成，自己写set方法
    //方法必须以set开头，不能随便写
//    public void setMySQLUserDao(UserDao xyz){
//        this.userDao = xyz;
//    }

    private VipDao vipDao;

    public void setVipDao(VipDao vipDao) {
        this.vipDao = vipDao;
    }

    public void saveUser(){
        //保存用户信息到数据库
        userDao.insert();
        vipDao.insert();
    }

}
