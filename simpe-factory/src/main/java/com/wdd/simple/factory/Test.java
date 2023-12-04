package com.wdd.simple.factory;

/**
 * 客户端程序
 */
public class Test {
    public static void main(String[] args) {
        //需要坦克
        //对于客户端来说，坦克的生产细节，不需要关心，只需要向工厂索要即可
        //简单工厂模式达到职责分离，客户端不需要关心产品的生产信息，只消费，工厂类只生产
        //一个负责生产，一个负责消费，生产者和消费者分离了，就是简单工厂的作用
        Weapon tank = WeaponFactory.get("TANK");
        tank.attack();
        Weapon dagger = WeaponFactory.get("DAGGER");
        dagger.attack();
        Weapon fighter = WeaponFactory.get("Fighter");
        fighter.attack();
    }
}
