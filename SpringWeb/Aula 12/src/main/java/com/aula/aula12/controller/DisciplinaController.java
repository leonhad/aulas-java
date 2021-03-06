package com.aula.aula12.controller;

import com.aula.aula12.entity.CursoEntity;
import com.aula.aula12.entity.DisciplinaEntity;
import com.aula.aula12.repository.CursoRepository;
import com.aula.aula12.repository.DisciplinaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/disciplinas")
public class DisciplinaController {

    private final DisciplinaRepository disciplinaRepository;

    private final CursoRepository cursoRepository;

    public DisciplinaController(DisciplinaRepository disciplinaRepository, CursoRepository cursoRepository) {
        this.disciplinaRepository = disciplinaRepository;
        this.cursoRepository = cursoRepository;
    }

    @GetMapping("pesquisa")
    public String pesquisa(@RequestParam(required = false, defaultValue = "") String nome,
                           @RequestParam(required = false, defaultValue = "0") Integer curso,
                           Model model) {

        CursoEntity cursoEntity = cursoRepository.findById(curso).orElse(null);
        List<DisciplinaEntity> disciplinas = disciplinaRepository.findByNomeIgnoreCaseContainingAndCurso(nome,
                cursoEntity);

        model.addAttribute("disciplinas", disciplinas);
        model.addAttribute("cursos", cursoRepository.findAll());
        model.addAttribute("nome", nome);
        model.addAttribute("curso", curso);

        return "/cadastros/pesquisaDisciplina";
    }
}
