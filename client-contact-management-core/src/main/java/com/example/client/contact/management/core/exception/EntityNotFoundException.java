package com.example.client.contact.management.core.exception;

public class EntityNotFoundException extends BaseException{

    public EntityNotFoundException(ErrorMessage error) {
        super(error);
    }
}
