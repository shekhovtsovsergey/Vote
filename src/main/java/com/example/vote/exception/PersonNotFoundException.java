package com.example.vote.exception;

public class PersonNotFoundException extends ObjectNotFoundException {

    public PersonNotFoundException(Integer personId) {
        super(String.format("Person id %s not found", personId));
    }

    public PersonNotFoundException(String message) {
        super(message);
    }
}
