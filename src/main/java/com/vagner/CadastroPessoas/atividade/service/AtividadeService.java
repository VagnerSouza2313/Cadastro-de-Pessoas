package com.vagner.CadastroPessoas.atividade.service;

import com.vagner.CadastroPessoas.atividade.domain.Atividade;
import com.vagner.CadastroPessoas.atividade.dto.AtividadeDto;
import com.vagner.CadastroPessoas.atividade.mappers.AtividadeDtoMapper;
import com.vagner.CadastroPessoas.atividade.repository.AtividadeRepository;
import com.vagner.CadastroPessoas.pessoa.domain.Pessoa;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AtividadeService {

    AtividadeRepository atividadeRepository;
    AtividadeDtoMapper atividadeDtoMapper;

    public AtividadeService(AtividadeRepository atividadeRepository, AtividadeDtoMapper atividadeDtoMapper) {
        this.atividadeRepository = atividadeRepository;
        this.atividadeDtoMapper = atividadeDtoMapper;
    }

    //Create activity
    public AtividadeDto create(AtividadeDto atividadeDto){
        Atividade atividade = atividadeDtoMapper.toDomain(atividadeDto);
        atividadeRepository.save(atividade);
        return  atividadeDtoMapper.toDto(atividade);
    }

    //Read activity
    public List<AtividadeDto> read(){
        List<Atividade> atividadeList = atividadeRepository.findAll();
        return atividadeList.stream().map(atividadeDtoMapper::toDto).collect(Collectors.toList());
    }

    //Read by id
    public AtividadeDto readId(Long id){
        Optional<Atividade> atividade = atividadeRepository.findById(id);
        return atividade.map(atividadeDtoMapper::toDto).orElse(null); //fazer exceções
    }

    //Update activity
    public AtividadeDto update(Long id, AtividadeDto atividadeDto){
        Optional<Atividade> atividade = atividadeRepository.findById(id);
        if (atividade.isPresent()){
            Atividade atividadeUpdate = atividade.get();
            atividadeUpdate.setDescricao(atividadeDto.getDescricao());
            atividadeUpdate.setGrauAtividade(atividadeDto.getGrauAtividade());
            Atividade atividadeSave = atividadeRepository.save(atividadeUpdate);
            return atividadeDtoMapper.toDto(atividadeSave);
        }
        else {
            return null;
        }
    }

    //Delete activity
    public void delete(Long id){
        atividadeRepository.deleteById(id);
    }

}
