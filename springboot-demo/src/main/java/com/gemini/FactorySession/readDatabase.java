package com.gemini.FactorySession;

public class readDatabase implements Operations{

    @Override
    public void Connection() {
        System.out.println("connection called for Read operation");
    }

    @Override
    public void ExcuteQuery() {
        System.out.println("select * from table");
    }

    @Override
    public void CloseConnection() {

        System.out.println("close connection");
    }
}
