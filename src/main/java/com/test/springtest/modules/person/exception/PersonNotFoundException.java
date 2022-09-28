package com.test.springtest.modules.person.exception;

public class PersonNotFoundException extends RuntimeException {

    public PersonNotFoundException(){
        super("Person Id Not Found");
    }
}
