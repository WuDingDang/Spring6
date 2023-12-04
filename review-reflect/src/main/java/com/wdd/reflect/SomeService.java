package com.wdd.reflect;

public class SomeService {
    public void doSome(){
        System.out.println("dosome()...");
    }

    public String doSome(String s){
        System.out.println("doSome(String s)...");
        return s;
    }
    public String doSome(String s,int i){
        System.out.println("dosome(String s,int i)...");
        return s+i;
    }
}
