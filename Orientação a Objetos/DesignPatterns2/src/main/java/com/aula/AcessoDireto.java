package com.aula;

public class AcessoDireto extends AbstractConsulta {
    @Override
    protected void inicia() {
        System.out.println("Se conecta no banco");
    }

    @Override
    protected void finaliza() {
        System.out.println("Desconecta do banco");
    }

    @Override
    protected String get(String valor) {
        return "Recuperado do banco: " + valor;
    }
}
