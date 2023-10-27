package com.example.client.contact.management.core.exception;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.NOT_FOUND;

/**
 * The ErrorMessage enum represents error messages with associated error codes and HTTP statuses.
 * <p>
 * This enum is used to define and categorize error messages that can be associated with exceptions
 * in the application, making it easier to handle and communicate specific error scenarios.
 */
@Getter
@RequiredArgsConstructor
public enum ErrorMessage {


    ENTITY_NOT_FOUND(1, HttpStatus.NOT_FOUND, "The requested entity was not found."),
    ACCESS_DENIED(4031, HttpStatus.FORBIDDEN, "Access to the requested resource is denied."),
    CLIENT_EMAIL_ALREADY_EXIST(2, HttpStatus.CONFLICT, "The client email already exists."),
    BAD_REQUEST(3, HttpStatus.BAD_REQUEST, "Validation failed due to incorrect request data."),
    CLIENT_NOT_FOUND(4, NOT_FOUND, "Client not found."),
    CLIENT_PHONE_NUMBER_NOT_FOUND(5, NOT_FOUND, "Client phone number not found."),
    CLIENT_EMAIL_NOT_FOUND(6, NOT_FOUND, "Client email not found.");


    private final Integer code;
    private final HttpStatus httpStatus;
    private final String message;
}