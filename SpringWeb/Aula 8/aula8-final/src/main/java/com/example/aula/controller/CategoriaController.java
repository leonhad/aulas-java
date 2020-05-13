package com.example.aula.controller;

import com.example.aula.entity.CategoriaEntity;
import com.example.aula.repository.CategoriaRepository;
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
@RequestMapping("/categorias")
public class CategoriaController {
    
    @Autowired
    private CategoriaRepository categoriaRepository;
    
    @GetMapping("/nome/{nome}")
    public List<CategoriaEntity> findByNome(@PathVariable String nome) {
        return categoriaRepository.findByNome(nome);
    }
    
    @GetMapping
    public List<CategoriaEntity> listAll() {
        return categoriaRepository.findAll();
    }
    
    @PostMapping
    public CategoriaEntity create(@RequestBody CategoriaEntity categoria) {
        return categoriaRepository.save(categoria);
    }
    
    @GetMapping(path = "/{id}")
    public CategoriaEntity get(@PathVariable Long id) {
        return categoriaRepository.getOne(id);
    }
    
    @PutMapping
    public CategoriaEntity update(@RequestBody CategoriaEntity categoria) {
        return categoriaRepository.save(categoria);
    }
    
    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable Long id) {
        categoriaRepository.deleteById(id);
    }
}
