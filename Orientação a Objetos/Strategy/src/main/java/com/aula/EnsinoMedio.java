package com.aula;

import java.util.ArrayList;
import java.util.List;

public class EnsinoMedio extends NotaFinal {
    private List<Float> recuperacao = new ArrayList<>();

    @Override
    public float getMedia() {
        ArrayList<Float> resultado = new ArrayList<>();
        for (int i = 0; i < notas.size(); i++) {
            float notaRecuperacao = recuperacao.size() > i ? recuperacao.get(i) : 0f;
            float nota = notas.get(i);
            if (nota < 5f && notaRecuperacao > nota) {
                nota = notaRecuperacao;
            }
            resultado.add(nota);
        }

        float media = 0f;
        for (Float nota : resultado) {
            media += nota;
        }
        media /= (float) resultado.size();
        return media;
    }

    @Override
    public boolean isAprovado() {
        float media = getMedia();
        return media >= 5f;
    }

    @Override
    public void addRecuperacao(Float nota) {
        recuperacao.add(nota);
    }

    @Override
    public boolean isRecuperacao() {
        return !isAprovado() && recuperacao.size() < notas.size();
    }
}
