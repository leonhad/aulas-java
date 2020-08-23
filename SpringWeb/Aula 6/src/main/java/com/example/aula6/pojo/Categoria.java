package com.example.aula6.pojo;

import com.example.aula6.entity.CategoriaEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;

public class Categoria implements Serializable {

    private Long id;

    private String nome;

    public Categoria() {
        super();
    }

    public Categoria(CategoriaEntity categoria) {
        this.id = categoria.getId();
        this.nome = categoria.getNome();
    }

    @JsonIgnore
    public CategoriaEntity toEntity() {
        CategoriaEntity entity = new CategoriaEntity();
        entity.setId(id);
        entity.setNome(nome);
        return entity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
