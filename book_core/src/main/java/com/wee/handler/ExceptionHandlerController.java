package com.wee.handler;

import com.wee.exception.BookAlreadyExistException;
import com.wee.exception.BookNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

import static org.springframework.http.HttpStatus.CONFLICT;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(BookNotFoundException.class)
    @ResponseStatus(value = NOT_FOUND)
    @ResponseBody
    public String handleBookNotFoundException(HttpServletRequest request, BookNotFoundException exception) {
        Map<String, Object> errorMap = new HashMap<String, Object>();
        errorMap.put("status", NOT_FOUND);
        errorMap.put("Request", request.getRequestURL());
        errorMap.put("message", exception.getMessage());
        return errorMap.toString();
    }

    @ExceptionHandler(BookAlreadyExistException.class)
    @ResponseStatus(value = CONFLICT)
    @ResponseBody
    public String handleBookAlreadyExistException(HttpServletRequest request, BookAlreadyExistException exception) {
        Map<String, Object> errorMap = new HashMap<String, Object>();
        errorMap.put("status", CONFLICT);
        errorMap.put("Request", request.getRequestURL());
        errorMap.put("message", exception.getMessage());
        return errorMap.toString();
    }
}
