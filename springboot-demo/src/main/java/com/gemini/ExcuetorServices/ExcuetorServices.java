package com.gemini.ExcuetorServices;

import java.util.concurrent.Callable;

public class ExcuetorServices {



    public Runnable newRunnable(int number){
        return  new Runnable() {
            @Override
            public void run() {
                System.out.println("task "+number+" started");
                int sum=0;
                for (int i =number;i<=number+10;i++ ){
                    sum+=i;
                }
                System.out.println(sum+" Task "+ number+" Completed");
            }
        };
    }

    public Callable newCallable(int number){
        return new Callable() {
            @Override
            public Object call() throws Exception {
                System.out.println("task"+number+" started");
                int sum =0;
                for (int i =number;i<=number+10;i++ ){
                    sum+=i;
                }
                return sum+" task"+number+ " completed";
            }
        };
    }

}
