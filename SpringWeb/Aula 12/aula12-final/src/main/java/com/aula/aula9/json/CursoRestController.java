package com.aula.aula9.json;

import com.aula.aula9.controller.retorno.Curso;
import com.aula.aula9.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/rest/cursos")
public class CursoRestController {
    @Autowired
    private CursoRepository cursoRepository;

    @GetMapping
    public List<Curso> findAll() {
        return cursoRepository.findAll().stream().map(Curso::new)
                .collect(Collectors.toList());
    }
}
