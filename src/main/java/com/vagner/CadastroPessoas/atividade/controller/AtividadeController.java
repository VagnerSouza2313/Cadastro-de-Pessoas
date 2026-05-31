package com.vagner.CadastroPessoas.atividade.controller;

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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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



}
