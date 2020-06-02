package com.aula;

import java.util.ArrayList;
import java.util.List;

public class LazyInitialization {
    private String nome;
    private List<String> valores;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<String> getValores() {
        if (valores == null) {
            valores = new ArrayList<>();
            System.out.println("Lazy");
        }
        return valores;
    }

    public void setValores(List<String> valores) {
        this.valores = valores;
    }
}
