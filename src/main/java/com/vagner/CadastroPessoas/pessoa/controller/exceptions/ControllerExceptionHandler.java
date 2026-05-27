package com.vagner.CadastroPessoas.pessoa.controller.exceptions;

import com.vagner.CadastroPessoas.pessoa.service.exceptions.EmailDuplicateException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(EmailDuplicateException.class)
    public ResponseEntity<StandardError> EmailDuplicate(EmailDuplicateException e, HttpServletRequest request){
        StandardError error = new StandardError();
        error.setTimestamp(Instant.now());
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setError("Email already registered");
        error.setMessage(e.getMessage());
        error.setPath(request.getRequestURI());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
    }

}
