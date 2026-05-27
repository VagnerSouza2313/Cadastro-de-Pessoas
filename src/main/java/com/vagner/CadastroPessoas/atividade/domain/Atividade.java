package com.vagner.CadastroPessoas.atividade.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vagner.CadastroPessoas.atividade.enums.GrauAtividade;
import com.vagner.CadastroPessoas.pessoa.domain.Pessoa;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "tb_atividade")
public class Atividade{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descricao;
    private GrauAtividade grauAtividade;

    @OneToMany(mappedBy = "atividade")
    @JsonIgnore
    private List<Pessoa> pessoas = new ArrayList<>();


}
