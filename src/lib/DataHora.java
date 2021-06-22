package lib;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DataHora {
    private static DateFormat dataFormatada = new SimpleDateFormat("yyyy-MM-dd");
    private static DateFormat dataFormatada2 = new SimpleDateFormat("dd/MM/yyyy");
    private static DateFormat horaFormatada = new SimpleDateFormat("HH:mm:ss");
    private static DateFormat anoFormatado = new SimpleDateFormat("yyyy");
    private static Calendar calendario = Calendar.getInstance();

    public static boolean validarHora(String hora) {
        horaFormatada.setLenient(false);

        try {
            horaFormatada.format(horaFormatada.parse(hora));
        } catch (ParseException erro) {
            return false;
        }

        return true;
    }

    public static boolean validarData(String data) {
        dataFormatada.setLenient(false);

        try {
            dataFormatada.format(dataFormatada.parse(data));
        } catch (ParseException erro) {
            return false;
        }

        return true;
    }

    public static boolean validarAno(String ano) {
        anoFormatado.setLenient(false);

        try {
            anoFormatado.format(anoFormatado.parse(ano));
        } catch (ParseException erro) {
            return false;
        }

        return true;
    }

    public static Date formatarHora(String hora) {
        Date date = null;

        try {
            date = horaFormatada.parse(hora);
            calendario.setTime(date);
            date = calendario.getTime();
        } catch (ParseException erro) {
            erro.printStackTrace();
        }

        return date;
    }

    public static Date formatarData(String data) {
        Date date = null;

        try {
            date = dataFormatada.parse(data);
            calendario.setTime(date);
            date = calendario.getTime();
        } catch (ParseException erro) {
            erro.printStackTrace();
        }

        return date;
    }

    public static Date formatarDataPadraoBrasileiro(String data) {
        Date date = null;

        try {
            date = dataFormatada2.parse(data);
            calendario.setTime(date);
            date = calendario.getTime();
        } catch (ParseException erro) {
            erro.printStackTrace();
        }

        return date;
    }
    
    public static String personalizarHora(Date date) {
        return horaFormatada.format(date);
    }
    
    public static String personalizarData(Date date) {
        return dataFormatada.format(date);
    }

    public static String converterData(String data) {
        Date date = formatarDataPadraoBrasileiro(data);
        return personalizarData(date);
    }
}
