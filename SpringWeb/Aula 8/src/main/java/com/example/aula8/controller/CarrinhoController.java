package com.example.aula8.controller;

import com.example.aula8.pojo.Carrinho;
import com.example.aula8.repository.CarrinhoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/carrinhos")
public class CarrinhoController {

    private final CarrinhoRepository carrinhoRepository;

    public CarrinhoController(CarrinhoRepository carrinhoRepository) {
        this.carrinhoRepository = carrinhoRepository;
    }

    @GetMapping
    public List<Carrinho> listAll() {
        return carrinhoRepository.findAll().stream().map(Carrinho::new).collect(Collectors.toList());
    }

    @PostMapping
    public Carrinho create(@RequestBody Carrinho carrinho) {
        return new Carrinho(carrinhoRepository.save(carrinho.toEntity()));
    }

    @GetMapping(path = "/{id}")
    public Carrinho get(@PathVariable Long id) {
        return new Carrinho(carrinhoRepository.getOne(id));
    }

    @PutMapping
    public Carrinho update(@RequestBody Carrinho carrinho) {
        return new Carrinho(carrinhoRepository.save(carrinho.toEntity()));
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable Long id) {
        carrinhoRepository.deleteById(id);
    }
}
