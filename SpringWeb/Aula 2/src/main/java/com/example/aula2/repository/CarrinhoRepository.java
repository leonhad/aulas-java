package com.example.aula2.repository;

import com.example.aula2.entity.CarrinhoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarrinhoRepository extends JpaRepository<CarrinhoEntity, Long> {

}
