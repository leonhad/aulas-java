package com.example.aula7.controller;

import com.example.aula7.entity.CarrinhoEntity;
import com.example.aula7.repository.CarrinhoRepository;
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
@RequestMapping("/carrinhos")
public class CarrinhoController {

    @Autowired
    private CarrinhoRepository carrinhoRepository;

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
