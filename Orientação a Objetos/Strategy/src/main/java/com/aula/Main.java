package com.aula;

public class Main {
    public static void main(String[] args) {
        NotaFinal notas = new EnsinoMedio();
        //NotaFinal notas = new Uniceplac();
        notas.add(4f);
        notas.add(2f);

        System.out.println("Média: " + notas.getMedia());
        System.out.println("Aprovado: " + (notas.isAprovado() ? "Sim" : "Não"));
        System.out.println("Recuperação: " + (notas.isRecuperacao() ? "Sim" : "Não"));

        notas.addRecuperacao(2f);
        notas.addRecuperacao(6f);

        System.out.println();
        System.out.println("Média: " + notas.getMedia());
        System.out.println("Aprovado: " + (notas.isAprovado() ? "Sim" : "Não"));
        System.out.println("Recuperação: " + (notas.isRecuperacao() ? "Sim" : "Não"));
    }
}
