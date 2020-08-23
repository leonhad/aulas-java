package com.aula.aula10.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class DateUtils {

    private DateUtils() {
        // Classe utilitária.
    }

    public static Date parse(String data) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            format.setLenient(false);
            return format.parse(data);
        } catch (ParseException e) {
            return null;
        }
    }

    public static String format(Date data) {
        if (data == null) {
            return "";
        }
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        return format.format(data);
    }
}
