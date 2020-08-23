package com.example.aula3.pojo;

import com.example.aula3.entity.ProdutoEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class Produto {
    private Long id;

    private String nome;

    private Categoria categoria;

    private Double valor;

    public Produto() {
        super();
    }

    public Produto(ProdutoEntity produto) {
        this.id = produto.getId();
        this.categoria = new Categoria(produto.getCategoria());
        this.valor = produto.getValor();
    }

    @JsonIgnore
    public ProdutoEntity toEntity() {
        ProdutoEntity entity = new ProdutoEntity();
        entity.setId(id);
        entity.setNome(nome);
        entity.setCategoria(categoria.toEntity());
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

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
}
