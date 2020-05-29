package com.aula;

public class Uniceplac extends NotaFinal {
    private Float recuperacao;

    @Override
    public float getMedia() {
        float media = super.getMedia();
        if (recuperacao != null) {
            return (media + recuperacao) / 2f;
        }
        return media;
    }

    @Override
    public boolean isAprovado() {
        float media = getMedia();
        return media >= 6f;
    }

    @Override
    public void addRecuperacao(Float nota) {
        recuperacao = nota;
    }

    @Override
    public boolean isRecuperacao() {
        return !isAprovado() && recuperacao == null;
    }
}
