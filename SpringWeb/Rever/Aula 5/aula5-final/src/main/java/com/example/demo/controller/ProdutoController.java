package com.example.demo.controller;

import com.example.demo.entity.Produto;
import com.example.demo.repository.ProdutoRepository;
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
@RequestMapping(path = "/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping
    public List<Produto> list() {
        return produtoRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Produto> get(@PathVariable Long id) {
        Optional<Produto> optional = produtoRepository.findById(id);
        if (optional.isPresent()) {
            return ResponseEntity.ok(optional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Produto create(@RequestBody Produto produto) {
        produto.setId(0L);
        return produtoRepository.save(produto);
    }

    @PutMapping
    public Produto update(@RequestBody Produto produto) {
        return produtoRepository.save(produto);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Produto> delete(@PathVariable Long id) {
        try {
            produtoRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (EmptyResultDataAccessException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
