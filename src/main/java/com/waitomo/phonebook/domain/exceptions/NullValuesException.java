package com.waitomo.phonebook.domain.exceptions;

public class NullValuesException extends RuntimeException{
    public NullValuesException(String message){
        super(message);
    }
}
