/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.awt.FlowLayout;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;

/**
 *
 * @author Loli Pop
 */
public class PanelProxAlarma extends JPanel {
    private JTextField ingresar;

    public PanelProxAlarma() {
        initComponents();
    }

    private void initComponents() {
        
        FlowLayout distribucion = new FlowLayout();
        this.setLayout(distribucion);   
        JSeparator separator = new JSeparator();
        this.ingresar = new JTextField("Proxima Alarma : 13:00");
        this.add(separator);
        this.add(this.ingresar);
        
    }
}
