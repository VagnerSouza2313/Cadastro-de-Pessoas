package com.vagner.CadastroPessoas.pessoa.controller;

import com.vagner.CadastroPessoas.pessoa.service.PessoaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class PessoasController {

    private final PessoaService pessoaService;


    public PessoasController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @GetMapping("/teste")
    public String teste(){
        return "Teste ok";
    }

}
