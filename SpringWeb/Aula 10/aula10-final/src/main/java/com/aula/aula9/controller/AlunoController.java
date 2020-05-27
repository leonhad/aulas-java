package com.aula.aula9.controller;

import com.aula.aula9.controller.retorno.Aluno;
import com.aula.aula9.entity.AlunoEntity;
import com.aula.aula9.repository.AlunoRepository;
import com.aula.aula9.utils.CpfUtils;
import com.aula.aula9.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoRepository alunoRepository;

    @RequestMapping("pesquisa")
    public String pesquisa(@RequestParam(required = false, defaultValue = "") String nome, Model model) {
        List<AlunoEntity> alunos = alunoRepository.findByNomeIgnoreCaseContaining(nome);

        model.addAttribute("alunos", alunos.stream().map(Aluno::new).collect(Collectors.toList()));
        model.addAttribute("nome", nome);

        return "/cadastros/pesquisaAluno";
    }

    @GetMapping("novo")
    public String novo(Model model) {
        model.addAttribute("id", "");
        model.addAttribute("aluno", new AlunoEntity());
        return "/cadastros/cadastroAluno";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Integer id, Model model) {
        model.addAttribute("id", id);
        model.addAttribute("aluno", alunoRepository.findById(id).get());
        return "/cadastros/cadastroAluno";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Integer id, Model model) {
        alunoRepository.deleteById(id);
        return pesquisa("", model);
    }

    @PostMapping("salvar")
    public String salvar(@RequestParam String nome, @RequestParam String cpf, @RequestParam String data, Model model) {
        AlunoEntity alunoEntity = new AlunoEntity();
        alunoEntity.setNome(nome);
        alunoEntity.setCpf(CpfUtils.parse(cpf));
        alunoEntity.setNascimento(DateUtils.parse(data));
        alunoRepository.save(alunoEntity);

        model.addAttribute("mensagem", "Registro incluído com sucesso");

        return pesquisa(nome, model);
    }

    @PostMapping("salvar/{id}")
    public String salvar(@PathVariable Integer id, @RequestParam String nome, @RequestParam String cpf,
                         @RequestParam String data, Model model) {
        AlunoEntity alunoEntity = new AlunoEntity();
        alunoEntity.setId(id);
        alunoEntity.setNome(nome);
        alunoEntity.setCpf(CpfUtils.parse(cpf));
        alunoEntity.setNascimento(DateUtils.parse(data));
        alunoRepository.save(alunoEntity);

        model.addAttribute("mensagem", "Registro alterado com sucesso");

        return pesquisa(nome, model);
    }
}
