package com.waitomo.phonebook.domain.exceptions;

public class AlreadyExistsException extends RuntimeException{
    public AlreadyExistsException(String object){
        super(object + " já existe");
    }
}
