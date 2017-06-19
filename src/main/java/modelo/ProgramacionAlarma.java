package modelo;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class ProgramacionAlarma {

    private ArrayList<Date> horas;

    public ProgramacionAlarma(Medicamento med) {
        this.horas = new ArrayList<>();
        programarAlarmas(med);
    }

    public Date obtenerHora(int indice) {
        return this.horas.get(indice);
    }

    public void programarAlarmas(Medicamento medicamento) {

        Calendar nuevaHora = Calendar.getInstance();
        nuevaHora.setTime(medicamento.getFechaInicio());

        for (int i = 0; i < medicamento.getCantidadDosis(); i++) {

            int intervalo = (int) medicamento.getHoras();
            nuevaHora.add(nuevaHora.HOUR_OF_DAY, intervalo);
            Date dateHora = new Date();
            dateHora = nuevaHora.getTime();
            añadirHora(dateHora);
            medicamento.setFechaTermino(dateHora);
        }

    }

    public void añadirHora(Date nuevaHora) {
        this.horas.add(nuevaHora);
    }

    public ArrayList<Date> getHoras() {
        return horas;
    }

    public String[][] obtenerHorarios() {

        String[][] datos = new String[this.horas.size()][2];
        for (int i = 0; i < datos.length; i++) {
            for (int j = 0; j < 2; j++) {
                Date dateM = horas.get(i);
                Calendar c = Calendar.getInstance();
                c.setTime(dateM);
                String dia = ("Dia : " + c.get(c.DATE));
                String hora = ("Hora: " + c.get(c.HOUR_OF_DAY) + " : " + c.get(c.MINUTE) + " : " + c.get(c.SECOND));
                datos[i][0] = dia;
                datos[i][1] = hora;

            }
        }
        return datos;
    }

    public Calendar dateToCalendar(Date date) {
        Calendar cal = null;
        try {
            DateFormat formatter = new SimpleDateFormat("yyyyMMdd");
            date = (Date) formatter.parse(date.toString());
            cal = Calendar.getInstance();
            cal.setTime(date);
        } catch (ParseException e) {
            System.out.println("Exception :" + e);
        }
        return cal;
    }

    public Date obtenerHorasEnHoras(int indice) {

        return this.horas.get(indice);
    }

}
