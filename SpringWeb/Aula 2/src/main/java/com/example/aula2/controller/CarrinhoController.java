package com.example.aula2.controller;

import com.example.aula2.entity.CarrinhoEntity;
import com.example.aula2.repository.CarrinhoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carrinhos")
public class CarrinhoController {

    private final CarrinhoRepository carrinhoRepository;

    public CarrinhoController(CarrinhoRepository carrinhoRepository) {
        this.carrinhoRepository = carrinhoRepository;
    }

    @GetMapping
    public List<CarrinhoEntity> listAll() {
        return carrinhoRepository.findAll();
    }

    @PostMapping
    public CarrinhoEntity create(@RequestBody CarrinhoEntity produto) {
        return carrinhoRepository.save(produto);
    }

    @GetMapping(path = "/{id}")
    public CarrinhoEntity get(@PathVariable Long id) {
        return carrinhoRepository.getOne(id);
    }

    @PutMapping
    public CarrinhoEntity update(@RequestBody CarrinhoEntity produto) {
        return carrinhoRepository.save(produto);
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable Long id) {
        carrinhoRepository.deleteById(id);
    }
}
