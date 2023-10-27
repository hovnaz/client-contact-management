package com.example.client.contact.management.core.exception;

/**
 * The EntityNotFoundException class is a custom exception class representing an entity not found error.
 * <p>
 * This exception is typically thrown when an attempt is made to access or manipulate an entity
 * that does not exist in the system, and it is used to handle situations where an entity is not found.
 */
public class EntityNotFoundException extends BaseException {

    public EntityNotFoundException(ErrorMessage error) {
        super(error);
    }
}
