package com.vagner.CadastroPessoas.atividade.domain;

import com.vagner.CadastroPessoas.atividade.enums.GrauAtividade;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

}
