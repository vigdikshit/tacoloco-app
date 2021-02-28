package com.tacoLoco.app.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;


@ControllerAdvice
public class ServerException
{   
    @ExceptionHandler(InvalidOrderQuantityException.class)
    public final ResponseEntity<Object> handleException(InvalidOrderQuantityException ex, WebRequest request) 
    {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
}
