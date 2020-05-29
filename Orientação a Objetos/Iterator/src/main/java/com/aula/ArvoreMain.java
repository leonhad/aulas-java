package com.aula;

import java.util.TreeSet;

public class ArvoreMain {
    public static void main(String[] args) {
        TreeSet<String> arvore = new TreeSet<>();
        arvore.add("alunos");
        arvore.add("professores");
        arvore.add("faltosos");

        for (String valor : arvore) {
            System.out.println(valor);
        }
    }
}
