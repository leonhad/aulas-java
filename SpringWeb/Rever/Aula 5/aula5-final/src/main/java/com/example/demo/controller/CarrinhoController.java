package com.example.demo.controller;

import com.example.demo.entity.Carrinho;
import com.example.demo.repository.CarrinhoRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/carrinhos")
public class CarrinhoController {
    
    @Autowired
    private CarrinhoRepository carrinhoRepository;
    
    @GetMapping
    public List<Carrinho> list() {
        return carrinhoRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Carrinho> get(@PathVariable Long id) {
        Optional<Carrinho> optional = carrinhoRepository.findById(id);
        if (optional.isPresent()) {
            return ResponseEntity.ok(optional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Carrinho create(@RequestBody Carrinho carrinho) {
        carrinho.setId(0L);
        return carrinhoRepository.save(carrinho);
    }

    @PutMapping
    public Carrinho update(@RequestBody Carrinho produto) {
        return carrinhoRepository.save(produto);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Carrinho> delete(@PathVariable Long id) {
        try {
            carrinhoRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (EmptyResultDataAccessException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
