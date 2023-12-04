package com.wdd.spring6.bean;

import org.springframework.stereotype.Component;

@Component(value = "userBean")
// 相当于<bean id="userBean" class="com.wdd.spring6.bean.User"/>
//属性名如果是value，value可以省略
//把整个value都省略，bean默认名称是类名首字母变小写 eg:user
//@Component   相当于<bean id="user" class="com.wdd.spring6.bean.User"/>
public class User {
}
