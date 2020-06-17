package com.aula.aula9.repository;

import com.aula.aula9.entity.CursoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<CursoEntity, Integer> {
}
