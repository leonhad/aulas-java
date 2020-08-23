package com.example.aula1.pojo;

import com.example.aula1.entity.UsuarioEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class Usuario implements Serializable {
    private Long id;

    private String nome;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String senha;

    public Usuario() {
        super();
    }

    public Usuario(UsuarioEntity usuario) {
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.senha = usuario.getSenha();
    }

    @JsonIgnore
    public UsuarioEntity getEntity() {
        UsuarioEntity entity = new UsuarioEntity();
        entity.setId(this.id);
        entity.setNome(this.nome);
        entity.setSenha(this.senha);
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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
