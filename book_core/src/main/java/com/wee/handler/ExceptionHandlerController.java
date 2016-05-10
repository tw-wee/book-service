package com.wee.handler;

import com.wee.exception.ApiError;
import com.wee.exception.BookAlreadyExistException;
import com.wee.exception.BookInvalidException;
import com.wee.exception.BookNotFoundException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.List;

import static org.springframework.http.HttpStatus.*;

@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(BookNotFoundException.class)
    @ResponseStatus(value = NOT_FOUND)
    @ResponseBody
    public ApiError handleBookNotFoundException(BookNotFoundException exception) {
        return new ApiError(NOT_FOUND, exception.getMessage());
    }

    @ExceptionHandler(BookAlreadyExistException.class)
    @ResponseStatus(value = CONFLICT)
    @ResponseBody
    public ApiError handleBookAlreadyExistException(BookAlreadyExistException exception) {
        return new ApiError(CONFLICT, exception.getMessage());
    }

    @ExceptionHandler(BookInvalidException.class)
    @ResponseStatus(value = BAD_REQUEST)
    @ResponseBody
    public ApiError handleBookInvalidException(BookInvalidException exception) {
        ApiError apiError = new ApiError(BAD_REQUEST, exception.getMessage());
        handleBindingResult(apiError, exception.getFieldErrors());
        return apiError;
    }

    private void handleBindingResult(ApiError apiError, List<FieldError> fieldErrors) {
        HashMap<String, String> map = new HashMap<>();
        for (FieldError error : fieldErrors) {
            map.put(error.getField(), error.getDefaultMessage());
        }
        apiError.setErrorMap(map);
    }
}
