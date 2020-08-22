package com.aula.aula9.json;

import com.aula.aula9.controller.retorno.Disciplina;
import com.aula.aula9.entity.CursoEntity;
import com.aula.aula9.repository.CursoRepository;
import com.aula.aula9.repository.DisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/rest/disciplinas")
public class DisciplinaRestController {

    @Autowired
    private DisciplinaRepository disciplinaRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @GetMapping("/{id}")
    public List<Disciplina> findByCurso(@PathVariable Integer id) {
        CursoEntity curso = cursoRepository.findById(id).orElse(null);
        return disciplinaRepository.findByCurso(curso).stream().map(Disciplina::new).collect(Collectors.toList());
    }
}
