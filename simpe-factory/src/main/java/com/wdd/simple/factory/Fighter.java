package com.wdd.simple.factory;
/**
 * 具体产品角色
 */
public class Fighter extends Weapon{
    @Override
    public void attack() {
        System.out.println("Fighter 发射");
    }
}
