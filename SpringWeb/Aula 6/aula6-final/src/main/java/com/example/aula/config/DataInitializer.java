package com.example.aula.config;

import com.example.aula.entity.UsuarioEntity;
import com.example.aula.repository.UsuarioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @Override
    public void onApplicationEvent(ContextRefreshedEvent e) {
        List<UsuarioEntity> users = usuarioRepository.findAll();
        if (users.isEmpty()) {
            usuarioRepository.save(new UsuarioEntity("usuario", "123"));
        }
    }
    
}