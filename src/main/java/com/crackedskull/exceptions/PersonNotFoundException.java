package com.crackedskull.exceptions;

public class PersonNotFoundException extends Exception {

    public PersonNotFoundException() {
        super("Person not found");
    }
}
