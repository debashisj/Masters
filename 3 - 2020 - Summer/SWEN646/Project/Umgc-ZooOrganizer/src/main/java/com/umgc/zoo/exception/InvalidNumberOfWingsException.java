package com.umgc.zoo.exception;

public class InvalidNumberOfWingsException extends RuntimeException{
    public InvalidNumberOfWingsException(String message) {
        super("Invalid number of wings exception. " + message);
    }
}
