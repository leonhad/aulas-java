package com.aula.aula9.repository;

import com.aula.aula9.entity.CursoEntity;
import com.aula.aula9.entity.DisciplinaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DisciplinaRepository extends JpaRepository<DisciplinaEntity, Integer> {
    List<DisciplinaEntity> findByNomeIgnoreCaseContainingAndCurso(String nome, CursoEntity curso);

    List<DisciplinaEntity> findByCurso(CursoEntity curso);
}
