package com.vagner.CadastroPessoas.pessoa.service.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class EmailDuplicateException extends RuntimeException {

    public EmailDuplicateException(String message){
        super(message);
    }
}
