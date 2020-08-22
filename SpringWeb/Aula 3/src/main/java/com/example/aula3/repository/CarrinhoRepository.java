package com.example.aula3.repository;

import com.example.aula3.entity.CarrinhoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarrinhoRepository extends JpaRepository<CarrinhoEntity, Long> {

}
