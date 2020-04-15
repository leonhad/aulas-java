package aula;

import lista.ListaEncadeada;

public class Teste {
    public static void main(String[] args) {
        ListaEncadeada lista = new ListaEncadeada();
        lista.add(1); // índice 0
        lista.add(2); // índice 1
        lista.add(3); // índice 2

        System.out.println("Total de itens: " + lista.size());

        for (int i = 0; i < lista.size(); i++) {
            System.out.println("Índice " + i + " valor " + lista.get(i));
        }
    }
}
