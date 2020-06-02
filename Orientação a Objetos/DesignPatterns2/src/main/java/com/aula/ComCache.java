package com.aula;

import java.util.HashMap;

public class ComCache extends AbstractConsulta {
    private HashMap<String, String> cache = new HashMap<>();

    @Override
    protected String get(String chave) {
        String v = cache.get(chave);
        if (v == null) {
            System.out.println("Recuperado do banco");
            cache.put(chave, "Valor da chave " + chave);
            v = cache.get(chave);
        } else {
            System.out.println("Recuperado do cache");
        }
        return v;
    }

}
