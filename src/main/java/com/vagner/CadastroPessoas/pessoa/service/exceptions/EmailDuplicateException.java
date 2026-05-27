package com.vagner.CadastroPessoas.pessoa.service.exceptions;
public class EmailDuplicateException extends RuntimeException {
    public EmailDuplicateException(String message){
        super(message);
    }
}
