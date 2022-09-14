package org.mustafa.springretrydemo.exception;

public class MyException extends RuntimeException {
    public MyException(String errorMessage) {  
        super(errorMessage);  
        }  
}