package com.example.aula2.controller;

import com.example.aula2.entity.ProdutoEntity;
import com.example.aula2.repository.ProdutoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoRepository produtoRepository;

    public ProdutoController(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

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
