package com.vagner.CadastroPessoas.person.controller;

import com.vagner.CadastroPessoas.person.dto.PersonDto;
import com.vagner.CadastroPessoas.person.service.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class PersonController {

    private final PersonService personService;


    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    //CRIAR PESSOA
    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody PersonDto personDto){
            personDto = personService.create(personDto);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body("Person created with success, name: " + personDto.getNome());
    }

    //BUSCAR TODOS
    @GetMapping("/readAll")
    public ResponseEntity<?> listAll(){
        List<PersonDto> pessoaList = personService.read();
        return ResponseEntity.ok(pessoaList);
    }

    //BUSCAR POR ID
    @GetMapping("/readId/{id}")
    public ResponseEntity<?> listById(@PathVariable Long id) {
        PersonDto personDto = personService.readId(id);
        if (personDto != null){
            return ResponseEntity.ok(personDto);
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Person not found in our records, ID: " + id);
        }
    }

    //ATUALIZAR PESSOA
    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@PathVariable Long id, @RequestBody PersonDto personDto){
        if (personService.readId(id) != null){
            personService.update(id, personDto);
            return ResponseEntity.ok("Person update success: " + personDto);
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Person with id: " + id + " not found in our records.");
        }
    }

    //DELETAR
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        personService.delete(id);
        return ResponseEntity.ok("Deleted success, ID: " + id);
    }


}
