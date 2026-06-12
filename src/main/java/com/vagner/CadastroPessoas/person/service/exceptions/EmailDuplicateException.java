package com.vagner.CadastroPessoas.person.service.exceptions;
public class EmailDuplicateException extends RuntimeException {
    public EmailDuplicateException(String message){
        super(message);
    }
}
