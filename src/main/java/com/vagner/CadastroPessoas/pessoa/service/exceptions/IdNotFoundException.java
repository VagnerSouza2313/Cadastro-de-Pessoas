package com.vagner.CadastroPessoas.pessoa.service.exceptions;

public class IdNotFoundException extends RuntimeException{
    public IdNotFoundException(String message){
        super(message);
    }
}
