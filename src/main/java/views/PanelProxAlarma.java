/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.awt.FlowLayout;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JLabel;

public class PanelProxAlarma extends JPanel {
    private JLabel ingresar;
    private String hora;
    private Date fechaActual;

    public PanelProxAlarma() {
        initComponents();
    }

    private void initComponents() {
        
        FlowLayout distribucion = new FlowLayout();
        this.setLayout(distribucion);   
        JSeparator separator = new JSeparator();
        
        Date fechaActual = new Date();
        DateFormat fecha = new SimpleDateFormat("HH:mm:ss");
        hora = (fecha.format(fechaActual));
        
        this.ingresar = new JLabel(hora);
        this.add(separator);
        this.add(this.ingresar);
        
    }
}
