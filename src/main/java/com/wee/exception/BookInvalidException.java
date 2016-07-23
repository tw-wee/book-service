package com.wee.exception;

import org.springframework.validation.FieldError;

import java.util.List;

public class BookInvalidException extends RuntimeException {
    private final List<FieldError> fieldErrors;

    public BookInvalidException(String message, List<FieldError> fieldErrors) {
        super(message);
        this.fieldErrors = fieldErrors;
    }

    public List<FieldError> getFieldErrors() {
        return fieldErrors;
    }
}
