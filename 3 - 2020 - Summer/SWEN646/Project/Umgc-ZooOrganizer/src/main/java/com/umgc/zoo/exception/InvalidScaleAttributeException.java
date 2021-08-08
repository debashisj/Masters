package com.umgc.zoo.exception;

public class InvalidScaleAttributeException extends RuntimeException{
    public InvalidScaleAttributeException(String message) {
        super("Invalid scale attribute exception. " + message);
    }
}
