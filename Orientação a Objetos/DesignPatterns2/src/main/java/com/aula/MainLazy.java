package com.aula;

import java.util.List;

public class MainLazy {
    public static void main(String[] args) {
        LazyInitialization lazy = new LazyInitialization();
        lazy.setNome("Teste");
        System.out.println("Nome: " + lazy.getNome());

        System.out.println("Antes do primeiro");
        lazy.getValores().add("Primeiro");
        System.out.println("Antes do segundo");
        lazy.getValores().add("Segundo");
        System.out.println("Antes do terceiro");
        lazy.getValores().add("Terceiro");

        System.out.println("For");
        List<String> valores = lazy.getValores();
        for (String valor : valores) {
            System.out.println(valor);
        }
     }
}
