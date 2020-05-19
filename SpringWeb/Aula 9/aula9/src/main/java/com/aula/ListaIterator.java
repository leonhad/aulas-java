package com.aula;

import java.util.Iterator;

public class ListaIterator implements Iterator<String> {

    private No atual;
    private boolean primeiro;

    public ListaIterator(No atual) {
        this.atual = atual;
        primeiro = true;
    }

    @Override
    public boolean hasNext() {
        return (primeiro && atual != null)
                || (!primeiro && atual.getProximo() != null);
    }

    @Override
    public String next() {
        No n;
        if (primeiro) {
            primeiro = false;
            n = atual;
        } else {
            atual = atual.getProximo();
            n = atual;
        }
        return n.getValor();
    }
}
