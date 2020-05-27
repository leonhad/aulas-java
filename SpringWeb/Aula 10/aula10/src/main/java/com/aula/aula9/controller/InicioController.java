package com.aula.aula9.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class InicioController {

    @RequestMapping("/")
    public String inicio(Model model) {
        return "index";
    }

    @PostMapping(value = "/login")
    public String login(@RequestParam String usuario, @RequestParam String senha, Model model) {
        model.addAttribute("email", usuario);
        return "inicio";
    }

    @GetMapping("/home")
    public String login(Model model) {
        return "inicio";
    }
}
