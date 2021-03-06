package com.example.aula7.controller;

import com.example.aula7.pojo.Usuario;
import com.example.aula7.repository.UsuarioRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
    public Usuario get(@PathVariable Long id) {
        return new Usuario(usuarioRepository.getOne(id));
    }

    @PutMapping
    public Usuario update(@RequestBody Usuario usuario) {
        return new Usuario(usuarioRepository.save(usuario.toEntity()));
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable Long id) {
        usuarioRepository.deleteById(id);
    }
}
