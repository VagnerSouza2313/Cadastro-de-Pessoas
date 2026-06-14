package com.vagner.CadastroPessoas.person.domain;

import com.vagner.CadastroPessoas.activity.domain.Activity;
import com.vagner.CadastroPessoas.person.enums.SocialStates;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "tb_pessoa")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPerson;

    private String nome;
    private int idade;
    private String email;
    private SocialStates socialStates;
    @ManyToOne
    @JoinColumn(name = "atividade_id")
    private Activity activity;

    public Long getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(Long idPerson) {
        this.idPerson = idPerson;
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

    public SocialStates getSocialStates() {
        return socialStates;
    }

    public void setSocialStates(SocialStates socialStates) {
        this.socialStates = socialStates;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }
}
