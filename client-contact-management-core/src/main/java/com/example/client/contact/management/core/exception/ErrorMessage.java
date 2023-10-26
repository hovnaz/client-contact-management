package com.example.client.contact.management.core.exception;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.NOT_FOUND;

/**
 * Error contains: CODE a unique code which value's first 3 numbers represent the response status
 * code. HTTP STATUS the response status code MESSAGE the error message
 */
@Getter
@RequiredArgsConstructor
public enum ErrorMessage {


    ENTITY_NOT_FOUND(1, HttpStatus.NOT_FOUND, "There Is No Entity With Such Id"),
    ACCESS_DENIED(4031, HttpStatus.FORBIDDEN, "Permission Denied To Requested Resource"),
    CLIENT_EMAIL_ALREADY_EXIST(2, HttpStatus.CONFLICT, "Client email already exist"),
    BAD_REQUEST(3, HttpStatus.BAD_REQUEST, "Validation failed"),
    CLIENT_NOT_FOUND(4, NOT_FOUND, "Client not found"),
    CLIENT_PHONE_NUMBER_NOT_FOUND(5, NOT_FOUND, "Client phone number not found"),
    CLIENT_EMAIL_NOT_FOUND(5, NOT_FOUND, "Client email not found");


    private final Integer code;
    private final HttpStatus httpStatus;
    private final String message;
}