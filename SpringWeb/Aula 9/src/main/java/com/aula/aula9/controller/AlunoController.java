package com.aula.aula9.controller;

import com.aula.aula9.controller.retorno.Aluno;
import com.aula.aula9.entity.AlunoEntity;
import com.aula.aula9.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoRepository alunoRepository;

    @GetMapping
    public List<Aluno> findAll() {
        final List<AlunoEntity> lista = alunoRepository.findAll();
        //return lista.stream().map(Aluno::new).collect(Collectors.toList());

        ArrayList<Aluno> alunos = new ArrayList<>();
        for (AlunoEntity alunoEntity : lista) {
            alunos.add(new Aluno(alunoEntity));
        }
        return alunos;
    }
}
