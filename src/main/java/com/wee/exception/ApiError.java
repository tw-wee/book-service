package com.wee.exception;

import java.util.HashMap;
import java.util.Map;

public class ApiError {
    private String message;
    private Map<String, String> errorMap = new HashMap<>();

    public ApiError(String message) {
        this.message = message;
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
