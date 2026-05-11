package com.vagner.CadastroPessoas.pessoa.service;

import com.vagner.CadastroPessoas.pessoa.domain.Pessoa;
import com.vagner.CadastroPessoas.pessoa.dto.PessoaDto;
import com.vagner.CadastroPessoas.pessoa.mappers.PessoaDtoMapper;
import com.vagner.CadastroPessoas.pessoa.repository.PessoaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PessoaService {

    private final PessoaRepository pessoaRepository;
    private final PessoaDtoMapper pessoaDtoMapper;

    public PessoaService(PessoaRepository pessoaRepository, PessoaDtoMapper pessoaDtoMapper) {
        this.pessoaRepository = pessoaRepository;
        this.pessoaDtoMapper = pessoaDtoMapper;
    }

    //Create people
    public PessoaDto create(PessoaDto pessoaDto){
        Pessoa pessoa1 = pessoaDtoMapper.toDomain(pessoaDto);
        pessoa1 = pessoaRepository.save(pessoa1);
        return pessoaDtoMapper.toDto(pessoa1);
    }

    //Read peoples
    public List<PessoaDto> read(){
        List<Pessoa> pessoaList = pessoaRepository.findAll();
        return pessoaList.stream().map(pessoaDtoMapper::toDto).collect(Collectors.toList());
    }


}
