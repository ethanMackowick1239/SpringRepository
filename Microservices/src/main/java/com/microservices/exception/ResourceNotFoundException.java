package com.microservices.exception;

public class ResourceNotFoundException extends Exception{

    public ResourceNotFoundException(String msg){
        super(msg);
    }
}
