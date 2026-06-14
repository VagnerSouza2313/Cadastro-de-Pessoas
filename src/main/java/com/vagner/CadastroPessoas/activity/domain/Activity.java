package com.vagner.CadastroPessoas.activity.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vagner.CadastroPessoas.activity.enums.ActivityDegree;
import com.vagner.CadastroPessoas.person.domain.Person;
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
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idActivity;
    private String descricao;
    private ActivityDegree activityDegree;

    @OneToMany(mappedBy = "activity")
    @JsonIgnore
    private List<Person> people = new ArrayList<>();


}
