package com.example.client.contact.management.web.endpoint.handler;

import com.example.client.contact.management.core.exception.ErrorMessage;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class ApiError {

    private HttpStatus status;
    private Integer errorCode;
    private final Instant timestamp;
    private String message;
    private Map<String, String> errors;

    public ApiError(ErrorMessage errorMessage, String message) {
        timestamp = Instant.now();
        this.status = errorMessage.getHttpStatus();
        this.errorCode = errorMessage.getCode();
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void addError(String field, String message) {
        if (errors == null) {
            errors = new HashMap<>();
        }
        errors.put(field, message);
    }
}