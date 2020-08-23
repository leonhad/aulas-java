package com.example.aula6.repository;

import java.util.List;

import com.example.aula6.entity.CategoriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<CategoriaEntity, Long>{
    
    List<CategoriaEntity> findByNome(String nome);
}
