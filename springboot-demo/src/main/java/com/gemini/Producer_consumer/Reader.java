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
            this.book.reader();
            try {
               sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
