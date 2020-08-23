package com.aula.aula12.controller.retorno;

import com.aula.aula12.entity.CursoEntity;

public class Curso {
    private Integer id;
    private String nome;

    public Curso(CursoEntity entity) {
        this.id = entity.getId();
        this.nome = entity.getNome();
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
}
