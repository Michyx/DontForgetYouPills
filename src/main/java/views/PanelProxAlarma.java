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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;

/**
 *
 * @author Loli Pop
 */
public class PanelProxAlarma extends JPanel {
   private JLabel ingresar;
    private Date fecha = new Date();
    private String hora;

    public PanelProxAlarma() {
        initComponents();
    }

    private void initComponents() {
        
        FlowLayout distribucion = new FlowLayout();
        this.setLayout(distribucion);   
        JSeparator separator = new JSeparator();
        
        DateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");
        hora = (formatoHora.format(fecha));
        
        this.ingresar = new JLabel(hora);
        this.add(separator);
        this.add(this.ingresar);
        
    }
}
