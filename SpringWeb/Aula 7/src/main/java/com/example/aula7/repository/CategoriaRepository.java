package com.example.aula7.repository;

import java.util.List;

import com.example.aula7.entity.CategoriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<CategoriaEntity, Long>{
    
    List<CategoriaEntity> findByNome(String nome);
}
