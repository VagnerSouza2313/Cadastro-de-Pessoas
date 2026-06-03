package com.vagner.CadastroPessoas.atividade.controller;

import com.sun.net.httpserver.HttpsServer;
import com.vagner.CadastroPessoas.atividade.domain.Atividade;
import com.vagner.CadastroPessoas.atividade.dto.AtividadeDto;
import com.vagner.CadastroPessoas.atividade.mappers.AtividadeDtoMapper;
import com.vagner.CadastroPessoas.atividade.repository.AtividadeRepository;
import com.vagner.CadastroPessoas.atividade.service.AtividadeService;
import com.vagner.CadastroPessoas.pessoa.domain.Pessoa;
import com.vagner.CadastroPessoas.pessoa.dto.PessoaDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Data
@RestController
@RequestMapping("atividade")
public class AtividadeController {

    private AtividadeService atividadeService;
    private AtividadeDtoMapper atividadeDtoMapper;

    public AtividadeController(AtividadeService atividadeService, AtividadeDtoMapper atividadeDtoMapper) {
        this.atividadeService = atividadeService;
        this.atividadeDtoMapper = atividadeDtoMapper;
    }

    //create activity
    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody AtividadeDto atividadeDto){
        atividadeDto = atividadeService.create(atividadeDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Activity created: " + atividadeDto.getId());
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
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Person not found in our records, ID: " + id);
        }
    }



}
