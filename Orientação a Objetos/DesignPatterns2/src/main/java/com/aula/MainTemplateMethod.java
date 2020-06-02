package com.aula;

public class MainTemplateMethod {
    public static void main(String[] args) {
        AbstractConsulta teste = new AcessoDireto();

        System.out.println(teste.recupera("123"));
        System.out.println(teste.recupera("123"));
        System.out.println(teste.recupera("123"));
        System.out.println(teste.recupera("321"));
    }
}
