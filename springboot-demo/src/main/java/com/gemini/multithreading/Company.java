package com.gemini.multithreading;

import com.gemini.imageUploading.service.StudentServicesImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import java.util.concurrent.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;

@Component
public class Company {

    BlockingQueue<Integer> queue=new LinkedBlockingQueue<>(10);
//    int size=10;
    int n;
    public static final Logger logger= LoggerFactory.getLogger(Company.class);
     public void produceItem(int n){
//        while(queue.size()==size){
//            try {
////                wait();
//                Thread.sleep(5000);
//            } catch (InterruptedException e) {
//                logger.info("Interrupted Exception");
//            }
//        }
         try {
             queue.put(this.n=n);
         } catch (InterruptedException e) {
             logger.info("Runtime Exception");
         }
         logger.info("Produced:"+Thread.currentThread().getId()+" "+n);
       // notify();
    }

     public int consumeItem (){
//        while(queue.size()==0){
//            try {
////                wait();
//                Thread.sleep(5000);
//            } catch (InterruptedException e) {
//                logger.info("Interrupted Exception");
//            }
//        }
         try {
             logger.info("Consumed:"+Thread.currentThread().getId()+" "+queue.take());
         } catch (InterruptedException e) {
             logger.info("Runtime Exception");
         }
         // notify();
        return n;
    }
}
