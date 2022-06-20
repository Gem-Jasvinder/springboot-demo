package com.gemini.springbootdemo.singletonPattern;

import org.springframework.stereotype.Component;

@Component
public class SychronisedSingleton {
    private static SychronisedSingleton instance;

    private SychronisedSingleton(){}

    public static SychronisedSingleton getInstance(){
        if(instance==null){
            synchronized (SychronisedSingleton.class){
                if (instance==null){
                    instance=new SychronisedSingleton();
                }
            }
        }
        return instance;
    }
}
