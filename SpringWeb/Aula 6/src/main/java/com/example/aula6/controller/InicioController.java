package com.example.aula6.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class InicioController {

    @RequestMapping("/")
    public String inicio(Model model){
        model.addAttribute("title", "Hello World!");
        return "index";
    }

    @PostMapping("/login")
    public String login(@RequestParam String usuario, @RequestParam String senha, Model model){
        model.addAttribute("email", usuario);
        return "inicio";
    }
}
