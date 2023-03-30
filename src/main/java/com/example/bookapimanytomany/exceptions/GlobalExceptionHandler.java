package com.example.bookapimanytomany.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers,
                                                                  HttpStatus status, WebRequest request) {
        Map<String, String> body = new HashMap<>();

        body.put("numberOfErrors", String.valueOf(ex.getBindingResult().getErrorCount()));
        ex.getBindingResult()
                .getFieldErrors()
                .forEach(fe -> body.put(fe.getField(), fe.getDefaultMessage()));

        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }
}
