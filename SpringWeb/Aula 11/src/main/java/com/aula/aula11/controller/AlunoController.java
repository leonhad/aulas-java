package com.aula.aula11.controller;

import com.aula.aula11.controller.retorno.Aluno;
import com.aula.aula11.entity.AlunoEntity;
import com.aula.aula11.exception.AvisoException;
import com.aula.aula11.repository.AlunoRepository;
import com.aula.aula11.utils.CpfUtils;
import com.aula.aula11.utils.DateUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/alunos")
public class AlunoController {

    public static final String ALUNO = "aluno";
    public static final String MENSAGEM = "mensagem";
    public static final String CADASTRO_ALUNO = "/cadastros/cadastroAluno";

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
        model.addAttribute(ALUNO, new AlunoEntity());
        return CADASTRO_ALUNO;
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Integer id, Model model) {
        model.addAttribute("id", id);
        model.addAttribute(ALUNO, alunoRepository.findById(id).orElse(null));
        return CADASTRO_ALUNO;
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

        try {
            if (cpf == null || cpf.trim().isEmpty()) {
                throw new AvisoException("O campo CPF é obrigatório.");
            }

            alunoRepository.save(alunoEntity);

            model.addAttribute(MENSAGEM, "Registro alterado com sucesso");

            return pesquisa(nome, model);
        } catch (AvisoException e) {
            model.addAttribute("mensagemAviso", e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("mensagemErro", e.getMessage());
        }

        model.addAttribute("id", id);
        model.addAttribute(ALUNO, alunoEntity);

        return CADASTRO_ALUNO;
    }
}
