package com.wee.exception;

import org.springframework.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

public class ApiError {
    private HttpStatus status;
    private String message;
    private Map<String, String> errorMap = new HashMap<>();

    public ApiError(HttpStatus status, String message) {
        this.message = message;
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<String, String> getErrorMap() {
        return errorMap;
    }

    public void setErrorMap(Map<String, String> errorMap) {
        this.errorMap = errorMap;
    }
}
