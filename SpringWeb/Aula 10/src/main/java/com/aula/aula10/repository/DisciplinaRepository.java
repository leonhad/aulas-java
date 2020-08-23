package com.aula.aula10.repository;

import com.aula.aula10.entity.DisciplinaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DisciplinaRepository extends JpaRepository<DisciplinaEntity, Integer> {
}
