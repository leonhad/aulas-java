package com.aula;

import java.util.Iterator;

public class MainLista {
    public static void main(String[] args) {
        Lista lista = new Lista();
        lista.add("Primeiro");
        lista.add("Segundo");
        lista.add("Terceiro");

        System.out.println("Foreach");
        for(String valor : lista) {
            System.out.println(valor);
        }
        System.out.println();
        System.out.println("Iterator");

        Iterator<String> i = lista.iterator();
        while(i.hasNext()) {
            String valor = i.next();
            System.out.println(valor);
        }

        System.out.println();
        System.out.println("For");
        for (int a = 0; a < lista.size(); a++) {
            String valor = lista.get(a);
            System.out.println(valor);
        }
    }
}
