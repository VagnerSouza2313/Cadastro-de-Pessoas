package com.vagner.CadastroPessoas.pessoa.service;

import com.vagner.CadastroPessoas.pessoa.service.exceptions.EmailDuplicateException;
import com.vagner.CadastroPessoas.pessoa.domain.Pessoa;
import com.vagner.CadastroPessoas.pessoa.dto.PessoaDto;
import com.vagner.CadastroPessoas.pessoa.mappers.PessoaDtoMapper;
import com.vagner.CadastroPessoas.pessoa.repository.PessoaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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
        if(pessoaRepository.existsByEmail(pessoa1.getEmail())){
            throw new EmailDuplicateException("Email already registered, register another email");
        }
        pessoaRepository.save(pessoa1);
        return pessoaDtoMapper.toDto(pessoa1);
    }

    //Read people
    public List<PessoaDto> read(){
        List<Pessoa> pessoaList = pessoaRepository.findAll();
        return pessoaList.stream().map(pessoaDtoMapper::toDto).collect(Collectors.toList());
    }

    //Read by id
    public PessoaDto readId(Long id){
        Optional<Pessoa> peopleId = pessoaRepository.findById(id);
        return peopleId.map(pessoaDtoMapper::toDto).orElse(null);
    }

    //Update people
    public PessoaDto update(Long id, PessoaDto pessoaDto){
        Optional<Pessoa> pessoaExiste = pessoaRepository.findById(id);
        if(pessoaExiste.isPresent()){
            Pessoa peopleUpdate = pessoaExiste.get();
            peopleUpdate.setNome(pessoaDto.getNome());
            peopleUpdate.setIdade(pessoaDto.getIdade());
            peopleUpdate.setEmail(pessoaDto.getEmail());
            peopleUpdate.setStatusSocial(pessoaDto.getStatusSocial());
            peopleUpdate.setAtividade(pessoaDto.getAtividade());
            Pessoa peopleSave = pessoaRepository.save(peopleUpdate);
            return pessoaDtoMapper.toDto(peopleSave);
        }
        return null;
    }

    //Delete people
    public void delete(Long id){
        pessoaRepository.deleteById(id);
    }


}
