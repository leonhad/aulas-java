package com.example.aula8.repository;

import java.util.List;

import com.example.aula8.entity.CategoriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<CategoriaEntity, Long>{
    
    List<CategoriaEntity> findByNome(String nome);
}
