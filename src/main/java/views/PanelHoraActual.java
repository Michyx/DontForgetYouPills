/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.awt.FlowLayout;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;

/**
 *
 * @author Loli Pop
 */
public class PanelHoraActual extends JPanel implements Runnable {

    private JLabel fecha;

    private Calendar fechaActual;
    private Thread hilo;

    public PanelHoraActual() {
        initComponents();
    }

    private void initComponents() {

        FlowLayout distribucion = new FlowLayout();
        this.setLayout(distribucion);

        this.hilo = new Thread(this);
        this.hilo.start();

    }

    @Override
    public void run() {
        Thread ct = Thread.currentThread();

        while (ct == hilo) {

            this.removeAll();
            JSeparator separator = new JSeparator();
            this.fechaActual = new GregorianCalendar();
            SimpleDateFormat formateador = new SimpleDateFormat("'Dia' : dd 'de' MMMM 'de' yyyy '/Hora' HH : mm : ss", new Locale("es_ES"));
            String label = formateador.format(fechaActual.getTime());

            this.fecha = new JLabel(label);
            this.add(separator);
            this.add(this.fecha);
            this.revalidate();
            try {
                this.hilo.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(PanelHoraActual.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
