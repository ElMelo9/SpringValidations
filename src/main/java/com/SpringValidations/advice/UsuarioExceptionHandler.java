package com.SpringValidations.advice;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class UsuarioExceptionHandler {


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String,String> handlerInvalidArguments(MethodArgumentNotValidException argumentNotValidException){
        Map<String,String>  errors = new HashMap<>();

        argumentNotValidException.getBindingResult().getFieldErrors().forEach(fieldError -> {
            errors.put(fieldError.getField(),fieldError.getDefaultMessage());
        });
    return errors;
    }


}
