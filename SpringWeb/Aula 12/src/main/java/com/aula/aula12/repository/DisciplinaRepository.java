package com.aula.aula12.repository;

import com.aula.aula12.entity.CursoEntity;
import com.aula.aula12.entity.DisciplinaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DisciplinaRepository extends JpaRepository<DisciplinaEntity, Integer> {
    List<DisciplinaEntity> findByNomeIgnoreCaseContainingAndCurso(String nome, CursoEntity curso);

    List<DisciplinaEntity> findByCurso(CursoEntity curso);
}
