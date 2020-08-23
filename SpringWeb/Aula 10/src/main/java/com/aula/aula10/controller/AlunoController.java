package com.aula.aula10.controller;

import com.aula.aula10.controller.retorno.Aluno;
import com.aula.aula10.entity.AlunoEntity;
import com.aula.aula10.repository.AlunoRepository;
import com.aula.aula10.utils.CpfUtils;
import com.aula.aula10.utils.DateUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/alunos")
public class AlunoController {

    public static final String MENSAGEM = "mensagem";

    private final AlunoRepository alunoRepository;

    public AlunoController(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    @GetMapping("pesquisa")
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
        model.addAttribute("aluno", alunoRepository.findById(id).orElse(null));
        return "/cadastros/cadastroAluno";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Integer id, Model model) {
        alunoRepository.deleteById(id);
        model.addAttribute(MENSAGEM, "Registro excluído com sucesso");
        return pesquisa("", model);
    }

    @PostMapping("salvar")
    public String salvar(@RequestParam String nome, @RequestParam String cpf, @RequestParam String data, Model model) {
        AlunoEntity alunoEntity = new AlunoEntity();
        alunoEntity.setNome(nome);
        alunoEntity.setCpf(CpfUtils.parse(cpf));
        alunoEntity.setNascimento(DateUtils.parse(data));
        alunoRepository.save(alunoEntity);

        model.addAttribute(MENSAGEM, "Registro incluído com sucesso");

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

        model.addAttribute(MENSAGEM, "Registro alterado com sucesso");

        return pesquisa(nome, model);
    }
}
