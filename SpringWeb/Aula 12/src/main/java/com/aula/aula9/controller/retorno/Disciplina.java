package com.aula.aula9.controller.retorno;

import com.aula.aula9.entity.DisciplinaEntity;

public class Disciplina {
    private Integer id;
    private String nome;

    public Disciplina(DisciplinaEntity entity) {
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
