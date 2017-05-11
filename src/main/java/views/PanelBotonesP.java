/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Loli Pop
 */
public class PanelBotonesP extends JPanel{
    
    private JButton btnIngresar;
    private JButton btnVerMedicamentos;
    private JButton btnEliminar;

    public PanelBotonesP() {
        initComponents();
    }

    private void initComponents() {
        
        GridLayout distribucion = new GridLayout(0,1);  
        setLayout(distribucion);
        this.btnEliminar = new JButton ("Eliminar ");
        this.btnIngresar = new JButton("Ingresar Medicamentos");
        this.btnVerMedicamentos = new JButton("Ver Detalle");
        
        this.add(this.btnEliminar);
        this.add(this.btnIngresar);
        this.add(this.btnVerMedicamentos);
        
    }

    public JButton getBtnIngresar() {
        return btnIngresar;
    }

    public JButton getBtnVerMedicamentos() {
        return btnVerMedicamentos;
    }

    public JButton getBtnEliminar() {
        return btnEliminar;
    }

    
}
