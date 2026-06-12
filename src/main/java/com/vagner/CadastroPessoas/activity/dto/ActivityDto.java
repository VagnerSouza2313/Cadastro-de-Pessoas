package com.vagner.CadastroPessoas.activity.dto;


import com.vagner.CadastroPessoas.activity.enums.ActivityDegree;
import com.vagner.CadastroPessoas.person.domain.Person;

import java.util.List;

public class ActivityDto {

    private Long id;
    private String descricao;
    private ActivityDegree activityDegree;
    private List<Person> personList;

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

    public ActivityDegree getGrauAtividade() {
        return activityDegree;
    }

    public void setGrauAtividade(ActivityDegree activityDegree) {
        this.activityDegree = activityDegree;
    }

    public List<Person> getPessoaList() {
        return personList;
    }

    public void setPessoaList(List<Person> personList) {
        this.personList = personList;
    }
}
