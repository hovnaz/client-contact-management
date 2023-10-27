package com.example.client.contact.management.web.endpoint.handler;

import com.example.client.contact.management.core.exception.BaseException;
import com.example.client.contact.management.core.exception.ConflictException;
import com.example.client.contact.management.core.exception.EntityNotFoundException;
import com.example.client.contact.management.core.exception.ErrorMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

/**
 * The GlobalExceptionHandler class handles exceptions and provides error responses for the application.
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     * A mapping of exception classes to error messages.
     */
    private static final Map<Class<? extends BaseException>, Supplier<ErrorMessage>> EXCEPTION_ERROR_MAP = new HashMap<>();

    static {
        EXCEPTION_ERROR_MAP.put(EntityNotFoundException.class, () -> ErrorMessage.ENTITY_NOT_FOUND);
        EXCEPTION_ERROR_MAP.put(ConflictException.class, () -> ErrorMessage.CLIENT_EMAIL_ALREADY_EXIST);
    }

    /**
     * Handles MethodArgumentNotValidException, typically raised when input validation fails.
     *
     * @param ex The MethodArgumentNotValidException.
     * @return A ResponseEntity with a validation error response.
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        BindingResult bindingResult = ex.getBindingResult();
        ApiError apiError = new ApiError(ErrorMessage.BAD_REQUEST, "Validation failed");
        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            apiError.addError(fieldError.getField(), fieldError.getDefaultMessage());
        }
        for (ObjectError error : ex.getBindingResult().getGlobalErrors()) {
            apiError.addError(error.getObjectName(), error.getDefaultMessage());
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiError);
    }

    /**
     * Handles runtime exceptions and returns an appropriate error response.
     *
     * @param e The exception to handle.
     * @return A ResponseEntity with an error response.
     */
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ApiError> handleException(BaseException e) {
        Supplier<ErrorMessage> errorSupplier = EXCEPTION_ERROR_MAP.getOrDefault(e.getClass(), () -> ErrorMessage.ACCESS_DENIED);
        ErrorMessage error = errorSupplier.get();

        ApiError apiError = createApiError(error, e.getError().getMessage());
        log.error(String.valueOf(e), error.getMessage());

        return ResponseEntity.status(apiError.getStatus()).body(apiError);
    }

    /**
     * Creates an ApiError object with the provided error message and message.
     *
     * @param error   The error message and associated HTTP status.
     * @param message The error message describing the error.
     * @return An ApiError object.
     */
    private ApiError createApiError(ErrorMessage error, String message) {
        return new ApiError(error, message);
    }
}
