package com.vagner.CadastroPessoas.atividade.dto;


import com.vagner.CadastroPessoas.atividade.enums.GrauAtividade;
import com.vagner.CadastroPessoas.pessoa.domain.Pessoa;

import java.util.List;

public class AtividadeDto {

    private Long id;
    private String descricao;
    private GrauAtividade grauAtividade;
    private List<Pessoa> pessoaList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public GrauAtividade getGrauAtividade() {
        return grauAtividade;
    }

    public void setGrauAtividade(GrauAtividade grauAtividade) {
        this.grauAtividade = grauAtividade;
    }

    public List<Pessoa> getPessoaList() {
        return pessoaList;
    }

    public void setPessoaList(List<Pessoa> pessoaList) {
        this.pessoaList = pessoaList;
    }
}
