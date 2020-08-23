package com.example.aula2.pojo;

import com.example.aula2.entity.ProdutoEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class Produto {
    private Long id;

    private String nome;

    private String categoria;

    private Double valor;

    public Produto() {
        super();
    }

    public Produto(ProdutoEntity produto) {
        this.id = produto.getId();
        this.categoria = produto.getCategoria();
        this.valor = produto.getValor();
    }

    @JsonIgnore
    public ProdutoEntity getEntity() {
        ProdutoEntity entity = new ProdutoEntity();
        entity.setId(id);
        entity.setNome(nome);
        entity.setCategoria(categoria);
        entity.setValor(valor);
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

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
}
