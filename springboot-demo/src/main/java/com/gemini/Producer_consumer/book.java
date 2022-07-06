package com.gemini.Producer_consumer;

import com.gemini.SpringbootDemoApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class book {

    public static final Logger logger= LoggerFactory.getLogger(book.class);
    int i=0;
    Stack<Integer> stack = new Stack<Integer>();
    synchronized public void writer() throws InterruptedException {

        if (!(stack.empty())){
            wait();
        }
       logger.info("Writer writes-"+i);
        stack.push(i);
        i++;
        Thread.sleep(3000);
        notify();

    }

     synchronized public void reader() throws InterruptedException {

        if (stack.empty()){
            wait();
        }
        logger.info("Reader reads-"+stack.pop());

        Thread.sleep(1000);

         notify();
    }
}
