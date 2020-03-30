package com.example.aula3.controller;

import com.example.aula3.entity.ProdutoEntity;
import com.example.aula3.repository.ProdutoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    
    @Autowired
    private ProdutoRepository produtoRepository;
    
    @GetMapping
    public List<ProdutoEntity> listAll() {
        return produtoRepository.findAll();
    }
    
    @PostMapping
    public ProdutoEntity create(@RequestBody ProdutoEntity produto) {
        return produtoRepository.save(produto);
    }
    
    @GetMapping(path = "/{id}")
    public ProdutoEntity get(@PathVariable Long id) {
        return produtoRepository.getOne(id);
    }
    
    @PutMapping
    public ProdutoEntity update(@RequestBody ProdutoEntity produto) {
        return produtoRepository.save(produto);
    }
    
    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable Long id) {
        produtoRepository.deleteById(id);
    }
}
