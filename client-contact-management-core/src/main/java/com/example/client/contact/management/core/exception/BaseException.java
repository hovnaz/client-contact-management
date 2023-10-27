package com.example.client.contact.management.core.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * The BaseException class is an abstract exception class that extends RuntimeException.
 * <p>
 * This class serves as a base for custom exception classes and provides a way to
 * associate an error message with an exception.
 */
@Getter
@Setter
public abstract class BaseException extends RuntimeException {

    protected final ErrorMessage error;

    public BaseException(ErrorMessage error) {
        this.error = error;
    }
}
