package com.vagner.CadastroPessoas.pessoa.mappers;

import com.vagner.CadastroPessoas.pessoa.domain.Pessoa;
import com.vagner.CadastroPessoas.pessoa.dto.PessoaDto;
import org.springframework.stereotype.Component;

@Component
public class PessoaDtoMapper {

    public Pessoa toDomain(PessoaDto pessoaDto){

        Pessoa pessoa = new Pessoa();

        pessoa.setId(pessoaDto.getId());
        pessoa.setNome(pessoaDto.getNome());
        pessoa.setIdade(pessoaDto.getIdade());
        pessoa.setEmail(pessoaDto.getEmail());
        pessoa.setStatusSocial(pessoaDto.getStatusSocial());
        return pessoa;
    }

    public PessoaDto toDto(Pessoa pessoa){

        PessoaDto pessoaDto = new PessoaDto();

        pessoaDto.setId(pessoa.getId());
        pessoaDto.setNome(pessoa.getNome());
        pessoaDto.setIdade(pessoa.getIdade());
        pessoaDto.setEmail(pessoa.getEmail());
        pessoaDto.setStatusSocial(pessoa.getStatusSocial());

        if(pessoa.getAtividade() != null){

            pessoaDto.setIdAtividade(
                    pessoa.getAtividade().getId()
            );

            pessoaDto.setAtividadeDesc(
                    pessoa.getAtividade().getDescricao()
            );
        }

        return pessoaDto;
    }
}