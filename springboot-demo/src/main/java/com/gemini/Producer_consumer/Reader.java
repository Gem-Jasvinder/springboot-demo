package com.gemini.Producer_consumer;

public class Reader  extends  Thread{

    book book;
    public Reader(book book){
        this.book=book;
    }

    public void run()
    {
        while(true)
        {
            try {
                this.book.reader();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
