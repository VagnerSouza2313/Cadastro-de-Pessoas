package com.vagner.CadastroPessoas.atividade.mappers;

import com.vagner.CadastroPessoas.atividade.domain.Atividade;
import com.vagner.CadastroPessoas.atividade.dto.AtividadeDto;
import org.springframework.stereotype.Component;

@Component
public class AtividadeDtoMapper {

    public Atividade toDomain(AtividadeDto atividadeDto){
        Atividade atividade = new Atividade();

        atividade.setId(atividadeDto.getId());
        atividade.setDescricao(atividadeDto.getDescricao());
        atividade.setGrauAtividade(atividadeDto.getGrauAtividade());
        atividade.setPessoas(atividadeDto.getPessoaList());
        return atividade;
    }

    public AtividadeDto toDto(Atividade atividade){
        AtividadeDto atividadeDto = new AtividadeDto();

        atividadeDto.setId(atividade.getId());
        atividadeDto.setDescricao(atividade.getDescricao());
        atividadeDto.setGrauAtividade(atividade.getGrauAtividade());
        atividadeDto.setPessoaList(atividade.getPessoas());
        return atividadeDto;
    }


}
