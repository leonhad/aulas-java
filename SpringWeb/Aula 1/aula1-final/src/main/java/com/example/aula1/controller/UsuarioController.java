package com.example.aula1.controller;

import com.example.aula1.entity.UsuarioEntity;
import com.example.aula1.repository.UsuarioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @RequestMapping(method = RequestMethod.GET)
    public List<UsuarioEntity> listAll() {
        return usuarioRepository.findAll();
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public UsuarioEntity incluir(@RequestBody UsuarioEntity usuario) {
        return usuarioRepository.save(usuario);
    }
    
    @RequestMapping(path = "/{id}")
    public UsuarioEntity get(@PathVariable Long id) {
        return usuarioRepository.getOne(id);
    }
}
