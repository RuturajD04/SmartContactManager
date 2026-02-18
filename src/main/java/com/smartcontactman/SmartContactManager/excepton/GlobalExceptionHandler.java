package com.smartcontactman.SmartContactManager.excepton;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

@RestControllerAdvice
public class GlobalExceptionHandler {
    public ResponseEntity<Map<String,String>>handleConstrainViolation(ConstraintViolationException exception)


    {
      Map<String ,String> errors=new LinkedHashMap<>();
        Set< ConstraintViolation<?>>constraintViolations=exception.getConstraintViolations();
        constraintViolations.forEach(constraintViolation -> {
            String nameProperty=constraintViolation.getPropertyPath().toString();
            String message=constraintViolation.getMessage();
            errors.put(nameProperty,message);
        });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}
