package com.wee.controller;

import com.wee.exception.BookNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@ControllerAdvice
public class ExceptionHandlingController {

    @ResponseStatus(value = NOT_FOUND, reason = "Book not found")
    @ExceptionHandler(BookNotFoundException.class)
    public void handleBookNotFoundException() {
    }
}
