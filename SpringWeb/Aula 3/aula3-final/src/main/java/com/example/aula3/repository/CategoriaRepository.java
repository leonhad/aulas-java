package com.example.aula3.repository;

import com.example.aula3.entity.CategoriaEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<CategoriaEntity, Long>{
    
    public List<CategoriaEntity> findByNome(String nome);
}
