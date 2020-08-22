package com.example.aula.repository;

import com.example.aula.entity.CategoriaEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<CategoriaEntity, Long>{
    
    public List<CategoriaEntity> findByNome(String nome);
}
