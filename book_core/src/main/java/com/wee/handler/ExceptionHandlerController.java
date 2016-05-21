package com.wee.handler;

import com.wee.exception.ApiError;
import com.wee.exception.BookAlreadyExistException;
import com.wee.exception.BookInvalidException;
import com.wee.exception.BookNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.List;

import static org.springframework.http.HttpStatus.*;

@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(BookNotFoundException.class)
    public ResponseEntity<ApiError> handleBookNotFoundException(BookNotFoundException exception) {
        return new ResponseEntity<>(new ApiError(exception.getMessage()), NOT_FOUND);
    }

    @ExceptionHandler(BookAlreadyExistException.class)
    public ResponseEntity<ApiError> handleBookAlreadyExistException(BookAlreadyExistException exception) {
        return new ResponseEntity<>(new ApiError(exception.getMessage()), CONFLICT);
    }

    @ExceptionHandler(BookInvalidException.class)
    public ResponseEntity<ApiError> handleBookInvalidException(BookInvalidException exception) {
        ApiError apiError = new ApiError(exception.getMessage());
        handleBindingResult(apiError, exception.getFieldErrors());
        return new ResponseEntity<>(apiError, BAD_REQUEST);
    }

    private void handleBindingResult(ApiError apiError, List<FieldError> fieldErrors) {
        HashMap<String, String> map = new HashMap<>();
        for (FieldError error : fieldErrors) {
            map.put(error.getField(), error.getDefaultMessage());
        }
        apiError.setErrorMap(map);
    }
}
