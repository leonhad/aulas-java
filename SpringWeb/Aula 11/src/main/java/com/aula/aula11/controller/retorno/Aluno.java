package com.aula.aula11.controller.retorno;

import com.aula.aula11.entity.AlunoEntity;
import com.aula.aula11.utils.CpfUtils;

import java.util.Date;

public class Aluno {
    private Integer id;
    private String nome;
    private String cpf;
    private Date nascimento;

    public Aluno() {
        super();
    }

    public Aluno(AlunoEntity entity) {
        this.id = entity.getId();
        this.nome = entity.getNome();
        this.nascimento = entity.getNascimento();
        this.cpf = CpfUtils.format(entity.getCpf());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
