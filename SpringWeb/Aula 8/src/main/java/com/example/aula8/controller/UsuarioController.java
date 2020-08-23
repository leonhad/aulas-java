package com.example.aula8.controller;

import com.example.aula8.entity.UsuarioEntity;
import com.example.aula8.pojo.Usuario;
import com.example.aula8.repository.UsuarioRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioRepository usuarioRepository;

    public UsuarioController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @GetMapping
    public List<UsuarioEntity> listAll() {
        return usuarioRepository.findAll();
    }

    @PostMapping
    public Usuario create(@RequestBody Usuario usuario) {
        return new Usuario(usuarioRepository.save(usuario.toEntity()));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<UsuarioEntity> get(@PathVariable Long id) {
        Optional<UsuarioEntity> usuario = usuarioRepository.findById(id);
        return usuario.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping
    public Usuario update(@RequestBody Usuario usuario) {
        return new Usuario(usuarioRepository.save(usuario.toEntity()));
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
