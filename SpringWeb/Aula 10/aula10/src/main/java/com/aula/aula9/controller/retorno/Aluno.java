package com.aula.aula9.controller.retorno;

import com.aula.aula9.entity.AlunoEntity;

import java.util.Date;

public class Aluno {
    private Integer id;
    private String nome;
    private Date data;
    private Date timestamp = new Date();

    public Aluno() {
    }

    public Aluno(AlunoEntity entity) {
        this.id = entity.getId();
        this.nome = entity.getNome();
        this.data = entity.getNascimento();
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
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

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
}
