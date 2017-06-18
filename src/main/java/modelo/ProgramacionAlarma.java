/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 *
 * @author Loli Pop
 */
public class ProgramacionAlarma {
    
    private ArrayList<Calendar> horas;

    
    public ProgramacionAlarma(Medicamento med) {
        this.horas = new ArrayList<>();
        programarAlarmas(med);
    }
    public Calendar obtenerHora(int indice){
    return this.horas.get(indice);
    }
    
    public void programarAlarmas(Medicamento medicamento){
        
  
    Calendar nuevaHora = medicamento.getFechaInicio();
    
        for (int i = 0; i < medicamento.getCantidadDosis(); i++) {
              
              System.out.println("Cantidad de dosis "+medicamento.getCantidadDosis());
              System.out.println("Dosis "+i);
            int intervalo = (int) medicamento.getHoras();
            nuevaHora.add(nuevaHora.HOUR_OF_DAY, intervalo);
            
            añadirHora(nuevaHora);
            
            medicamento.setFechaTermino(nuevaHora);
                SimpleDateFormat formateador = new SimpleDateFormat("'Dia' : dd 'de' MMMM 'de' yyyy '/Hora' HH : mm : ss", new Locale("es_ES"));
            String fecha = formateador.format(obtenerHora(0).getTime());
           System.out.println(fecha);
        }
        for (int i = 0; i < 3; i++) {
            
             System.out.println("Objeto num : "+i);
            SimpleDateFormat formateador = new SimpleDateFormat("'Dia' : dd 'de' MMMM 'de' yyyy '/Hora' HH : mm : ss", new Locale("es_ES"));
            String fecha = formateador.format(obtenerHora(i).getTime());
           System.out.println(fecha);
           
        }
    }
    public void añadirHora(Calendar nuevaHora) {
        this.horas.add(nuevaHora);
      
        SimpleDateFormat formateador = new SimpleDateFormat("'Dia' : dd 'de' MMMM 'de' yyyy '/Hora' HH : mm : ss", new Locale("es_ES"));
        String fecha = formateador.format(nuevaHora.getTime());
        System.out.println(fecha);
    }
    public ArrayList<Calendar> getHoras() {
        return horas;
    }
   
    public String [][] obtenerHorarios(){
    
      String [][] datos = new String[this.horas.size()][2];
        for (int i = 0; i < datos.length; i++) {
            for (int j = 0; j < 2; j++) {
                Calendar c = horas.get(i);
                String dia = ("Dia : "+c.get(c.DAY_OF_WEEK_IN_MONTH));
                String hora =("Hora: "+c.get(c.HOUR_OF_DAY));
                datos[i][0] = dia;
                datos [i][1] = hora;
                
            }
        }
    return datos;
    }
}
