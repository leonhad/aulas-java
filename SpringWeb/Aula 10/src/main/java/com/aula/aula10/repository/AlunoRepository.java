package com.aula.aula10.repository;

import com.aula.aula10.entity.AlunoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlunoRepository extends JpaRepository<AlunoEntity, Integer> {

    public List<AlunoEntity> findByNomeIgnoreCaseContaining(String nome);

}
