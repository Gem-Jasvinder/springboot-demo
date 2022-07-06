package com.gemini.Producer_consumer;

public class Writer extends Thread {

    book book;
    public Writer(book book){
        this.book=book;
    }

    public void run()
    {
        while(true)
        {
            try {
                this.book.writer();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }


        }
    }
}
