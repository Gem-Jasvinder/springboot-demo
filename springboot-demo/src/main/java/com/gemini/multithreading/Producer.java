package com.gemini.multithreading;

import com.gemini.imageUploading.service.StudentServicesImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class Producer extends Thread{

    public static final Logger logger= LoggerFactory.getLogger(Producer.class);
    Company c;
    public Producer(Company c){
        this.c=c;
    }
    public void run(){
        int n=1;
        while(true){
            this.c.produceItem(n);
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                logger.info("Interrupted Exception");
            }
            n++;
        }
    }
}
