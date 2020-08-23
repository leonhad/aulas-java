package com.aula.aula9.controller;

import com.aula.aula9.controller.retorno.Aluno;
import com.aula.aula9.entity.AlunoEntity;
import com.aula.aula9.repository.AlunoRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    private final AlunoRepository alunoRepository;

    public AlunoController(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    @GetMapping
    public List<Aluno> findAll() {
        final List<AlunoEntity> lista = alunoRepository.findAll();
        return lista.stream().map(Aluno::new).collect(Collectors.toList());
    }
}
