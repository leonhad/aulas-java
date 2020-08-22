package com.example.aula1.controller;

import com.example.aula1.entity.UsuarioEntity;
import com.example.aula1.repository.UsuarioRepository;
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
@RequestMapping("/usuarios")
public class UsuarioController {
    
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @GetMapping
    public List<UsuarioEntity> listAll() {
        return usuarioRepository.findAll();
    }
    
    @PostMapping
    public UsuarioEntity create(@RequestBody UsuarioEntity usuario) {
        return usuarioRepository.save(usuario);
    }
    
    @GetMapping(path = "/{id}")
    public UsuarioEntity get(@PathVariable Long id) {
        return usuarioRepository.getOne(id);
    }
    
    @PutMapping
    public UsuarioEntity update(@RequestBody UsuarioEntity usuario) {
        return usuarioRepository.save(usuario);
    }
    
    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable Long id) {
        usuarioRepository.deleteById(id);
    }
}
