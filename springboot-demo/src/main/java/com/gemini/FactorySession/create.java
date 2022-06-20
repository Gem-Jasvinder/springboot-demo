package com.gemini.FactorySession;

public class create implements  Operations{


    @Override
    public void Connection() {
        System.out.println("connection called For the Create Operations");
    }

    @Override
    public void ExcuteQuery() {

        System.out.println("CREATE TABLE TABLE-NAME");
    }

    @Override
    public void CloseConnection() {

        System.out.println("Close connection for the Create Operation");
    }
}
