package com.vagner.CadastroPessoas.pessoa.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.vagner.CadastroPessoas.atividade.domain.Atividade;
import com.vagner.CadastroPessoas.atividade.dto.AtividadeDto;
import com.vagner.CadastroPessoas.pessoa.enums.StatusSocial;

@JsonPropertyOrder({
        "id",
        "nome",
        "idade",
        "email",
        "statusSocial",
        "idAtividade",
        "atividadeDesc"
})
public class PessoaDto {

    private Long id;
    private String nome;
    private int idade;
    private String email;
    private StatusSocial statusSocial;
    private Long idAtividade;
    private String atividadeDesc;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public StatusSocial getStatusSocial() {
        return statusSocial;
    }

    public void setStatusSocial(StatusSocial statusSocial) {
        this.statusSocial = statusSocial;
    }

    public Long getIdAtividade() {
        return idAtividade;
    }

    public void setIdAtividade(Long idAtividade) {
        this.idAtividade = idAtividade;
    }

    public String getAtividadeDesc() {
        return atividadeDesc;
    }

    public void setAtividadeDesc(String atividadeDesc) {
        this.atividadeDesc = atividadeDesc;
    }
}
