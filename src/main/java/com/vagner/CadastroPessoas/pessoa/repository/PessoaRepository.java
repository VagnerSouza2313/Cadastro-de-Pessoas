package com.vagner.CadastroPessoas.pessoa.repository;

import com.vagner.CadastroPessoas.pessoa.domain.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

    boolean existsByEmail(String email);

}
