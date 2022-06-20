package com.gemini.FactorySession;

public class updateDatabase implements Operations {
    @Override
    public void Connection() {
        System.out.println("connection called for Update operation");
    }

    @Override
    public void ExcuteQuery() {
        System.out.println("Alter table");
    }

    @Override
    public void CloseConnection() {
        System.out.println("connection closed");
    }
}
