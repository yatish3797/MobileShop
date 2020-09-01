package com.axiom.mobileshop.exception;

public class InvalidParameterException extends RuntimeException{

    public InvalidParameterException(String errMsg) {
        super(errMsg);
    }
}
