package com.aula.aula9.repository;

import com.aula.aula9.entity.AlunoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<AlunoEntity, Integer> {
}
