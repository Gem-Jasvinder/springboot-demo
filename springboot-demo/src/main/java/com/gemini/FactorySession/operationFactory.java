package com.gemini.FactorySession;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
public class operationFactory {

    public Operations doOperations(String Operation){

        switch (Operation){
            case "CREATE":
                return new create();
            case "READ":
                return new readDatabase();
            case "UPDATE":
                return new updateDatabase();
            default:
                throw new IllegalArgumentException("Unknown channel ");
        }

    }
}
