package com.example.aula6.controller;

import com.example.aula6.pojo.Categoria;
import com.example.aula6.repository.CategoriaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    private final CategoriaRepository categoriaRepository;

    public CategoriaController(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @GetMapping("/nome/{nome}")
    public List<Categoria> findByNome(@PathVariable String nome) {
        return categoriaRepository.findByNome(nome).stream().map(Categoria::new).collect(Collectors.toList());
    }

    @GetMapping
    public List<Categoria> listAll() {
        return categoriaRepository.findAll().stream().map(Categoria::new).collect(Collectors.toList());
    }

    @PostMapping
    public Categoria create(@RequestBody Categoria categoria) {
        return new Categoria(categoriaRepository.save(categoria.toEntity()));
    }

    @GetMapping(path = "/{id}")
    public Categoria get(@PathVariable Long id) {
        return new Categoria(categoriaRepository.getOne(id));
    }

    @PutMapping
    public Categoria update(@RequestBody Categoria categoria) {
        return new Categoria(categoriaRepository.save(categoria.toEntity()));
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable Long id) {
        categoriaRepository.deleteById(id);
    }
}
