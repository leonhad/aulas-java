package com.aula.aula9.repository;

import com.aula.aula9.entity.AlunoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AlunoRepository extends JpaRepository<AlunoEntity, Integer> {

    public List<AlunoEntity> findByNomeIgnoreCaseContaining(String nome);

}
