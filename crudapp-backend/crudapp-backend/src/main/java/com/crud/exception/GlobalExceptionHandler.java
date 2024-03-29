package com.crud.exception;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ResponseBody
    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String,String> exceptionHandler(UserNotFoundException exception)
    {
        Map<String,String>errorMap=new HashMap<>();
        errorMap.put("errorMessage",exception.getMessage());
        return errorMap;
    }

    @ResponseBody
    @ExceptionHandler(ResourceAlreadyExistException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String,String> exceptionHandler(ResourceAlreadyExistException exception)
    {
        Map<String,String>errorMap=new HashMap<>();
        errorMap.put("errorMessage",exception.getMessage());
        return errorMap;
    }
}
