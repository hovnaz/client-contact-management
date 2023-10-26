package com.example.client.contact.management.core.exception;

public class ConflictException extends BaseException {

    public ConflictException(ErrorMessage error) {
        super(error);
    }
}
