package com.vagner.CadastroPessoas.atividade.repository;

import com.vagner.CadastroPessoas.atividade.domain.Atividade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AtividadeRepository extends JpaRepository<Atividade,Long>{
}
