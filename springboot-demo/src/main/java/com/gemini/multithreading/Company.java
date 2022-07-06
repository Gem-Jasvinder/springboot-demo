package com.gemini.multithreading;

import com.gemini.imageUploading.service.StudentServicesImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.Queue;

@Component
public class Company {

    Queue<Integer> queue=new LinkedList<>();
    int size=10;
    int n;
    public static final Logger logger= LoggerFactory.getLogger(Company.class);
    synchronized public void produceItem(int n){
        while(queue.size()==10){
            try {
                wait();
            } catch (InterruptedException e) {
                logger.info("Interrupted Exception");
            }
        }
        queue.add(this.n=n);
        logger.info("Produced:"+Thread.currentThread().getId()+" "+n);
        notify();
    }

    synchronized public int consumeItem (){
        while(queue.size()==0){
            try {
                wait();
            } catch (InterruptedException e) {
                logger.info("Interrupted Exception");
            }
        }
        logger.info("Consumed:"+Thread.currentThread().getId()+" "+queue.remove());
        notify();
        return n;
    }
}
