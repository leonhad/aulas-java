package com.example.aula2.pojo;

import com.example.aula2.entity.CarrinhoEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;
import java.util.stream.Collectors;

public class Carrinho {
    private Long id;

    private Usuario usuario;

    private List<Produto> produtos;

    public Carrinho() {
        super();
    }

    public Carrinho(CarrinhoEntity carrinho) {
        this.id = carrinho.getId();
        this.usuario = new Usuario(carrinho.getUsuario());
        this.produtos = carrinho.getProdutos().stream().map(Produto::new).collect(Collectors.toList());
    }

    @JsonIgnore
    public CarrinhoEntity getEntity() {
        CarrinhoEntity entity = new CarrinhoEntity();
        entity.setId(id);
        entity.setUsuario(usuario.getEntity());
        entity.setProdutos(produtos.stream().map(Produto::getEntity).collect(Collectors.toList()));
        return entity;
    }

    public Double getTotal() {
        double total = 0.0;

        if (produtos != null) {
            for (Produto produto : produtos) {
                if (produto.getValor() != null) {
                    total += produto.getValor();
                }
            }
        }

        return total;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
}
