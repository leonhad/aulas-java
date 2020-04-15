package aula;

import javax.swing.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Data {
    public static void main(String[] args) throws ParseException  {
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Date data= format.parse(JOptionPane
                .showInputDialog("Informe o nascimento em dd/mm/yyyy"));

        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(date);

        System.out.println("Dia: " + calendar.get(Calendar.DAY_OF_MONTH));
        System.out.println("Mes: " + (calendar.get(Calendar.MONTH) + 1));
        System.out.println("Ano: " + calendar.get(Calendar.YEAR));
        System.out.println("Hora: " + calendar.get(Calendar.HOUR_OF_DAY));
        System.out.println("Minuto: " + calendar.get(Calendar.MINUTE));
        System.out.println("Segundo: " + calendar.get(Calendar.SECOND));
        System.out.println("Dia da semana: " + calendar.get(Calendar.DAY_OF_WEEK));
    }
}
