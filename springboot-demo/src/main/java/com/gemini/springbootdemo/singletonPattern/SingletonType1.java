package com.gemini.springbootdemo.singletonPattern;

import org.springframework.stereotype.Component;

@Component
public class SingletonType1 {
    private static SingletonType1 instance;

    private SingletonType1(){}

    public static SingletonType1 getInstance(){
        if(instance==null){
            instance=new SingletonType1();
        }
        return instance;
    }

}
