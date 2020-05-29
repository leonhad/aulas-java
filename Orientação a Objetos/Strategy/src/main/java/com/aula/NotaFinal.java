package com.aula;

import java.util.ArrayList;
import java.util.List;

public abstract class NotaFinal {
    protected List<Float> notas = new ArrayList<>();

    public abstract boolean isAprovado();

    public void add(Float nota) {
        notas.add(nota);
    }

    public float getMedia() {
        float total = 0.0f;

        for (Float valor : notas) {
            total += valor;
        }
        total /= (float)notas.size();

        return total;
    }

    public abstract void addRecuperacao(Float nota);

    public abstract boolean isRecuperacao();
}
