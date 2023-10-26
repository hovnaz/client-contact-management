package com.example.client.contact.management.core.exception;

public class ClientEmailConflictException extends RuntimeException {

    public ClientEmailConflictException(String email) {
        super("Client with email " + email + " already exists.");
    }
}
