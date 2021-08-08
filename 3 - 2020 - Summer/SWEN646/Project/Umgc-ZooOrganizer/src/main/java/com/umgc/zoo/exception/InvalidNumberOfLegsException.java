package com.umgc.zoo.exception;

public class InvalidNumberOfLegsException extends RuntimeException{
    public InvalidNumberOfLegsException(String message) {
        super("Invalid number of legs exception. " + message);
    }
}
