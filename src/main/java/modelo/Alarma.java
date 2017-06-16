
package modelo;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;



public class Alarma {
    
    

    public void programarAlarma(Inventario inv){
     
        Date horaAlarma = new Date(System.currentTimeMillis());
        Calendar c = Calendar.getInstance();
        c.setTime(horaAlarma);
        System.out.println(c.get(Calendar.DAY_OF_WEEK));
               
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND,0);
        
        horaAlarma = c.getTime();
        System.out.println(horaAlarma);
        System.out.println(c.get(Calendar.DAY_OF_WEEK));
        
        int tiempoRepeticion = 86400000; //Suena 12 horas más
        
        Timer programacionHora = new Timer();
        programacionHora.schedule(new ProgramacionHora(), horaAlarma, tiempoRepeticion);
        
    }
  

}
