package com.example.client.contact.management.core.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class BaseException extends RuntimeException {

    protected final ErrorMessage error;

    public BaseException(ErrorMessage error) {
        this.error = error;
    }
}
