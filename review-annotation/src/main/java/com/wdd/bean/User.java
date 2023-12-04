package com.wdd.bean;

import com.wdd.annotation.Component;

//@Component(value="userbean")
//如果属性名是value，value可以省略
@Component("userbean")
public class User {
    //编译器报错，只能在类上
//    @Component(value="test")
//    private String name;
}
