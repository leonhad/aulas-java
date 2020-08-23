package com.aula.aula10.utils;

import javax.swing.text.MaskFormatter;
import java.text.ParseException;

public final class CpfUtils {

    private CpfUtils() {
        // Classe utilitária.
    }

    public static String format(Long cpf) {
        if (cpf == null) {
            return "";
        }

        try {
            String cpfString = cpf.toString();
            cpfString = "00000000000".substring(0, 11 - cpfString.length()) + cpfString;
            MaskFormatter mask = new MaskFormatter("###.###.###-##");
            mask.setValueContainsLiteralCharacters(false);
            return mask.valueToString(cpfString);
        } catch (ParseException e) {
            return "";
        }
    }

    public static Long parse(String cpf) {
        if (cpf == null || cpf.trim().isEmpty()) {
            return null;
        }

        return Long.valueOf(cpf.replaceAll("[.\\s-]+", "").trim());
    }
}
