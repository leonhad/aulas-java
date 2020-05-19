package com.aula;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Logger;

public class Main {

    private static final Logger LOGGER =
            Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        ArrayList<String> lista = new ArrayList<>();
        lista.add("Primeiro");
        lista.add("Segundo");
        lista.add("Terceiro");

        Iterator<String> i = lista.iterator();
        while(i.hasNext()) {
            String valor = i.next();
            if (valor.equals("Segundo")) {
                i.remove();
            } else {
                LOGGER.info(valor);
            }
        }

        for (String valor : lista) {
            System.out.println(valor);
        }

        for (int a = 0; a < lista.size(); a++) {
            String valor = lista.get(a);
            if (valor.equals("Segundo")) {
                lista.remove(a);
                a--;
            } else {
                System.out.println(valor);
            }
        }
    }
}
