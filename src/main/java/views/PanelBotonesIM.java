/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Loli Pop
 */
public class PanelBotonesIM extends JPanel{
    
     private JButton btnAceptar;
     private JButton btnCancelar;

    public PanelBotonesIM() {
        initComponents();
    }

    private void initComponents() {
        FlowLayout distribucion = new FlowLayout();
        btnAceptar = new JButton("Aceptar");
        btnCancelar = new JButton("Cancelar");
        
        this.add(btnAceptar);
        this.add(btnCancelar);
    }

    public JButton getBtnAceptar() {
        return btnAceptar;
    }

    public JButton getBtnCancelar() {
        return btnCancelar;
    }
     
     
     
}
