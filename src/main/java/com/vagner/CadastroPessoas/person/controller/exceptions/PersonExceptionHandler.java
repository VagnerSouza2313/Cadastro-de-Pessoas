package com.vagner.CadastroPessoas.person.controller.exceptions;

import com.vagner.CadastroPessoas.person.service.exceptions.EmailDuplicateException;
import com.vagner.CadastroPessoas.person.service.exceptions.IdNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class PersonExceptionHandler {

    @ExceptionHandler(EmailDuplicateException.class)
    public ResponseEntity<StandardError> EmailDuplicate(EmailDuplicateException e, HttpServletRequest request){
        StandardError error = new StandardError();
        error.setTimestamp(Instant.now());
        error.setStatus(HttpStatus.CONFLICT.value());
        error.setError("Email already registered");
        error.setMessage(e.getMessage());
        error.setPath(request.getRequestURI());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
    }

    @ExceptionHandler(IdNotFoundException.class)
    public ResponseEntity<StandardError> IdNotFound(IdNotFoundException e, HttpServletRequest request){
        StandardError error = new StandardError();
        error.setTimestamp(Instant.now());
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setError("Id not found");
        error.setMessage(e.getMessage());
        error.setPath(request.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

}
