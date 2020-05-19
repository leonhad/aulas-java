package com.aula;

import java.util.*;

public class HashMain {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("primeiro", 1);
        map.put("segundo", 2);
        map.put("terceiro", 3);

        Iterator<String> s = map.keySet().iterator();

        for (String chave : map.keySet()) {
            System.out.println(chave + "=" + map.get(chave));
        }

        System.out.println();
        System.out.println("Entry");
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }
    }
}
