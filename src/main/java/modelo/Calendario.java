
package modelo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;



public class Calendario implements Runnable{
    
    private Calendar c;
    private Thread hilo;

    public Calendario() {
        hilo = new Thread(this);
        hilo.start();
        this.c = new GregorianCalendar();
        SimpleDateFormat formateador = new SimpleDateFormat("dd 'de' MMMM 'de' yyyy", new Locale("es_ES"));
        System.out.println(formateador.format(c.getTime()));
    }

    public void calcula() {

        Locale l = new Locale("es", "CL");
        this.c = new GregorianCalendar();


    
    }
    @Override
    public void run() {
       Thread ct = Thread.currentThread();
        while (ct == hilo) {
          calcula();
          
            
        }
   
    }

}