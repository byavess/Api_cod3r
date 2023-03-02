package com.example.demo.exception;

public class ResourceNotFoundException  extends RuntimeException{
    private static final long serialVersionUID =1l;
    public ResourceNotFoundException(Object id){
        super("Resource not found. Id" + id);
    }
}
