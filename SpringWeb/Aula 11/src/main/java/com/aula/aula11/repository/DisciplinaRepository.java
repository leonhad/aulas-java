package com.aula.aula11.repository;

import com.aula.aula11.entity.DisciplinaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DisciplinaRepository extends JpaRepository<DisciplinaEntity, Integer> {
}
