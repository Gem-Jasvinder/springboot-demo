package com.gemini.Producer_consumer;

public class Writer extends Thread {

    book book;
    public Writer(book book){
        this.book=book;
    }

    public void run()
    {
        int n=1;
        while(true)
        {
            this.book.writer(n);
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            n++;


        }
    }
}
