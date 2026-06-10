package com.vagner.CadastroPessoas.atividade.controller;

import com.vagner.CadastroPessoas.atividade.dto.AtividadeDto;
import com.vagner.CadastroPessoas.atividade.service.AtividadeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("atividade")
public class AtividadeController {

    private AtividadeService atividadeService;

    public AtividadeController(AtividadeService atividadeService) {
        this.atividadeService = atividadeService;
    }

    //create activity
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody AtividadeDto atividadeDto){
        atividadeDto = atividadeService.create(atividadeDto);
        return ResponseEntity.ok(atividadeDto);
    }

    //read all
    @GetMapping("/read")
    public ResponseEntity<?> read(){
        List<AtividadeDto> list = atividadeService.read();
        return ResponseEntity.ok(list);
    }

    //read by id
    @GetMapping("/read/{id}")
    public ResponseEntity<?> readId(@PathVariable Long id){
        AtividadeDto atividadeDto = atividadeService.readId(id);
        if (atividadeDto != null){
            return ResponseEntity.ok(atividadeDto);
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Activity not found in our records, ID: " + id);
        }
    }

    //update activity
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody AtividadeDto atividadeDto){
        if (atividadeService.readId(id) != null){
            AtividadeDto atividadeDtoUpdate = atividadeService.update(id, atividadeDto);
            return ResponseEntity.ok(atividadeDtoUpdate);
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Activity with id: " + id + " not found in our records.");
        }
    }

    //delete activity
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        if (atividadeService.readId(id) != null){
            atividadeService.delete(id);
            return ResponseEntity.ok("Activity with id: " + id + " deleted.");
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Activity with id: " + id + " deleted.");
        }
    }


}
