package com.vagner.CadastroPessoas.person.repository;

import com.vagner.CadastroPessoas.person.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {

    boolean existsByEmail(String email);

}
