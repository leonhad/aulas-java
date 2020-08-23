package com.example.aula8.controller;

import com.example.aula8.pojo.Usuario;
import com.example.aula8.repository.UsuarioRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioRepository usuarioRepository;

    public UsuarioController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @GetMapping
    public List<Usuario> listAll() {
        return usuarioRepository.findAll().stream().map(Usuario::new).collect(Collectors.toList());
    }

    @PostMapping
    public Usuario create(@RequestBody Usuario usuario) {
        return new Usuario(usuarioRepository.save(usuario.toEntity()));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Usuario> get(@PathVariable Long id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id).map(Usuario::new);
        return usuario.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping
    public Usuario update(@RequestBody Usuario usuario) {
        return new Usuario(usuarioRepository.save(usuario.toEntity()));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Usuario> delete(@PathVariable Long id) {
        try {
            usuarioRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (EmptyResultDataAccessException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
