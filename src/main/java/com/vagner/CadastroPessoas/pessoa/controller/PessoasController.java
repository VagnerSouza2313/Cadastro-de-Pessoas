package com.vagner.CadastroPessoas.pessoa.controller;

import com.sun.net.httpserver.HttpsServer;
import com.vagner.CadastroPessoas.pessoa.dto.PessoaDto;
import com.vagner.CadastroPessoas.pessoa.service.PessoaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class PessoasController {

    private final PessoaService pessoaService;


    public PessoasController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    //CRIAR PESSOA
    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody PessoaDto pessoaDto){
        pessoaDto = pessoaService.create(pessoaDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("People created with success, name: " + pessoaDto.getNome());
    }

    //BUSCAR TODOS
    @GetMapping("/readAll")
    public ResponseEntity<?> listAll(){
        List<PessoaDto> pessoaList = pessoaService.read();
        return ResponseEntity.ok(pessoaList);
    }

    //BUSCAR POR ID
    @GetMapping("/readId/{id}")
    public ResponseEntity<?> listById(@PathVariable Long id) {
        PessoaDto pessoaDto = pessoaService.readId(id);
        if (pessoaDto != null){
            return ResponseEntity.ok(pessoaDto);
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("People not found in our registres, ID: " + id);
        }
    }

    //DELETAR
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        pessoaService.delete(id);
        return ResponseEntity.ok("Deleted success, ID: " + id);
    }


}
