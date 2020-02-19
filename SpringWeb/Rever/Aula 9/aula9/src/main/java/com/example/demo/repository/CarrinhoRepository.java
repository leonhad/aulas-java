package com.example.demo.repository;

import com.example.demo.entity.Carrinho;
import com.example.demo.entity.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarrinhoRepository extends JpaRepository<Carrinho, Long> {

    public List<Carrinho> findByUser(User user);

}
