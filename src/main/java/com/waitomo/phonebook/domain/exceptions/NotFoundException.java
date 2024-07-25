package com.waitomo.phonebook.domain.exceptions;


public class NotFoundException extends RuntimeException{
    public NotFoundException(String object,String sufix){
        super(object + " não encontrad" + sufix);
    }
}
