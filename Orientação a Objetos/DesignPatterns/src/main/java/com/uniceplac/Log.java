package com.uniceplac;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Log {
    private static Log instance ;

    private Log() {
    }

    public static Log getInstance() {
        if (instance == null) {
            instance = new Log();
        }
        return instance;
    }

    public void log(String mensagem) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(String.format("%s - %s", format.format(new Date()), mensagem));
    }
}
