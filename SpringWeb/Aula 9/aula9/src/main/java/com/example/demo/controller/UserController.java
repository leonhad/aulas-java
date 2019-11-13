package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<User> list() {
        return userRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    public User get(@PathVariable Long id) {
        return userRepository.getOne(id);
    }

    @PostMapping()
    public User create(@Valid @RequestBody User user) {
        user.setId(0L);
        return userRepository.save(user);
    }
}
