package modelo;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import views.Sonido;

public class Alarma implements Runnable {

    private Calendar c;
    private Thread hilo;
    private ConjuntoAlarmas alarmas;
    private boolean terminar;
    private Inventario inv;

    public Alarma(ConjuntoAlarmas alarmas, Inventario i) {
        hilo = new Thread(this);
        this.alarmas = alarmas;
        this.inv = i;
        this.terminar = false;
        this.c = new GregorianCalendar();
        hilo.start();
    }

    public Date getFechaActual() {

        Locale l = new Locale("es", "CL");
        this.c = new GregorianCalendar();
        Date fechaA = new Date();
        fechaA = c.getTime();
        return fechaA;

    }

    public void compararFecha(ConjuntoAlarmas alarmas) throws Exception {
        Date fechaAlarma = new Date();
        Calendar fechaComparar = new GregorianCalendar();
        for (int i = 0; i < alarmas.getSize(); i++) {
            for (int j = 0; j < alarmas.getAlarmas().get(i).getHoras().size(); j++) {
                fechaAlarma.setTime(alarmas.getAlarmas().get(i).getHoras().get(j).getTime());
                fechaComparar.setTime(fechaAlarma);
                SimpleDateFormat formateador = new SimpleDateFormat("'Dia' : dd 'de' MMMM 'de' yyyy '/Hora' HH : mm : ss", new Locale("es_ES"));
                String fecha = formateador.format(fechaAlarma.getTime());
                String fechaAct = formateador.format(getFechaActual().getTime());
//                System.out.println("Comparando : " + fecha + " con "+fechaAct );
                if (fecha.equals(fechaAct)) {
                    alarmaEject(i);
                }

            }

        }

    }

    public void alarmaEject(int indice) throws Exception {
        Sonido s = new Sonido();
        s.agregarSonido();
        JOptionPane.showMessageDialog(null, "Alarma Medicamento = " + this.inv.obtenerMedicamento(indice).getNombre() + " Dosis :  " + this.inv.obtenerMedicamento(indice).getDosisTotal() + " mg");

    }

    public void terminarHilo() {
        this.terminar = true;

    }

    @Override
    public void run() {

        Thread ct = Thread.currentThread();

        while (ct == hilo || this.terminar != true) {
            try {

                ct.sleep(1000);
                compararFecha(this.alarmas);

            } catch (InterruptedException ex) {
                Logger.getLogger(Alarma.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(Alarma.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

}
