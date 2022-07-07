package com.gemini.Producer_consumer;

import com.gemini.SpringbootDemoApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class book {

    public static final Logger logger= LoggerFactory.getLogger(book.class);
    int n;
    int capacity=10;
    Stack<Integer> stack = new Stack<Integer>();
    synchronized public void writer(int n)  {

        this.n=n;
        while (stack.size() == capacity){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        stack.push(n);
       logger.info("Writer writes-"+n);

        notify();

    }

     synchronized public void reader() {

        while(stack.empty()){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        logger.info("Reader reads-"+stack.pop());
         notify();
    }
}
