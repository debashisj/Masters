package com.umgc.zoo.exception;

public class InvalidAnimalException extends RuntimeException{
    public InvalidAnimalException(String message) {
        super("Invalid animal type exception. " + message);
    }
}
