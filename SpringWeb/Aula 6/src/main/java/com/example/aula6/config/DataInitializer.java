package com.example.aula6.config;

import com.example.aula6.entity.UsuarioEntity;
import com.example.aula6.repository.UsuarioRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataInitializer implements ApplicationListener<ContextRefreshedEvent> {

    private final UsuarioRepository usuarioRepository;

    public DataInitializer(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent e) {
        List<UsuarioEntity> users = usuarioRepository.findAll();
        if (users.isEmpty()) {
            usuarioRepository.save(new UsuarioEntity("usuario", "123"));
        }
    }

}
