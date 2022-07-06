package com.gemini.multithreading;

import com.gemini.imageUploading.service.StudentServicesImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class Consumer extends Thread{

    public static final Logger logger= LoggerFactory.getLogger(Consumer.class);

    Company c;
    public Consumer(Company c){
        this.c=c;
    }
    public void run(){
        while(true) {
            this.c.consumeItem();
            try {
                sleep(5000);
            } catch (InterruptedException e) {
                logger.info("Interrupted Exception");
            }
        }
    }
}
