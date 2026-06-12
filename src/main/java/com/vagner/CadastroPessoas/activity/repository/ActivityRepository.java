package com.vagner.CadastroPessoas.activity.repository;

import com.vagner.CadastroPessoas.activity.domain.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityRepository extends JpaRepository<Activity,Long>{
}
