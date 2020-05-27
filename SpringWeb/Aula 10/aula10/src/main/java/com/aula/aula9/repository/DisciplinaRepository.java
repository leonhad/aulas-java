package com.aula.aula9.repository;

import com.aula.aula9.entity.DisciplinaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DisciplinaRepository extends JpaRepository<DisciplinaEntity, Integer> {
}
