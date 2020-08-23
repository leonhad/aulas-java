package com.example.aula2.controller;

import com.example.aula2.pojo.Produto;
import com.example.aula2.repository.ProdutoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoRepository produtoRepository;

    public ProdutoController(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @GetMapping
    public List<Produto> listAll() {
        return produtoRepository.findAll().stream().map(Produto::new).collect(Collectors.toList());
    }

    @PostMapping
    public Produto create(@RequestBody Produto produto) {
        return new Produto(produtoRepository.save(produto.toEntity()));
    }

    @GetMapping(path = "/{id}")
    public Produto get(@PathVariable Long id) {
        return new Produto(produtoRepository.getOne(id));
    }

    @PutMapping
    public Produto update(@RequestBody Produto produto) {
        return new Produto(produtoRepository.save(produto.toEntity()));
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable Long id) {
        produtoRepository.deleteById(id);
    }
}
