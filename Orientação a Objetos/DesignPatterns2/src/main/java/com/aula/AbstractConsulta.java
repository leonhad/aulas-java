package com.aula;

public abstract class AbstractConsulta {

    public String recupera(String chave) {
        try {
            inicia();
            return get(chave);
        } finally {
            finaliza();
        }
    }

    protected void inicia() {
    }

    protected abstract String get(String valor);

    protected void finaliza() {
    }
}
