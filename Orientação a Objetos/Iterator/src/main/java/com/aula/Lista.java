package com.aula;

import java.util.Iterator;

public class Lista implements Iterable<String> {
    private No topo;

    public void add(String valor) {
        No no = new No();
        no.setValor(valor);

        if (topo == null) {
            topo = no;
        } else {
            No temp = topo;
            while (temp.getProximo() != null) {
                temp = temp.getProximo();
            }
            temp.setProximo(no);
        }
    }

    public String get(int index) {
        No temp = topo;
        for (int i = 0; i < index; i++) {
            temp = temp.getProximo();
        }
        return temp.getValor();
    }

    public int size() {
        int total = 0;
        No temp = topo;
        while (temp != null) {
            temp = temp.getProximo();
            total++;
        }
        return total;
    }

    @Override
    public Iterator<String> iterator() {
        return new ListaIterator(topo);
    }
}
