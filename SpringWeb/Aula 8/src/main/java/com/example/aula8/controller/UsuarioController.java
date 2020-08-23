package com.example.aula8.controller;

import com.example.aula8.entity.UsuarioEntity;
import com.example.aula8.repository.UsuarioRepository;
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
    public ResponseEntity<UsuarioEntity> get(@PathVariable Long id) {
        Optional<UsuarioEntity> usuario = usuarioRepository.findById(id);
        if (usuario.isPresent()) {
            return ResponseEntity.ok(usuario.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @PutMapping
    public UsuarioEntity update(@RequestBody UsuarioEntity usuario) {
        return usuarioRepository.save(usuario);
    }
    
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<UsuarioEntity> delete(@PathVariable Long id) {
        try {
            usuarioRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (EmptyResultDataAccessException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
