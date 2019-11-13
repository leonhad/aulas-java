package com.example.demo.config;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements ApplicationListener<ContextRefreshedEvent>{

    @Autowired
    private UserRepository userRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent e) {
        List<User> users = userRepository.findAll();
        if (users.isEmpty()) {
            User user = new User("usuario", "usuario@teste.com", "123");
            userRepository.save(user);
        }
    }
}
