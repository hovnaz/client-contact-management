package com.example.client.contact.management.core.exception;

/**
 * The ConflictException class is a custom exception class representing a conflict error.
 * <p>
 * This exception is typically thrown when there is a conflict in the system, such as
 * attempting to create a resource that already exists or update a resource that has
 * conflicting data.
 */
public class ConflictException extends BaseException {

    public ConflictException(ErrorMessage error) {
        super(error);
    }
}
