/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Loli Pop
 */
public class VentanaPrincipal extends JFrame implements ActionListener {
    
    
    private VentanaIngresarMedicamento ventanaIM;
    private PanelBotonesP panelBotones;
    private PanelProxAlarma panelAlarma;
    private PanelMedicamentosActivos panelMedicamentos;
    
    public VentanaPrincipal() {
        initComponents();
    }

    private void initComponents() {
         ventanaIM = new VentanaIngresarMedicamento();
        añadirComponentes();
       
       
       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       this.setTitle("Ventana Principal");
       this.setSize(400,300);
    }
    private void añadirComponentes(){
        
       
        panelBotones = new PanelBotonesP();
        panelAlarma = new PanelProxAlarma();
        panelMedicamentos = new PanelMedicamentosActivos();
    
        this.panelBotones.getBtnIngresar().addActionListener((ActionListener)this);
        this.panelBotones.getBtnEliminar().addActionListener((ActionListener)this);
        this.panelBotones.getBtnVerMedicamentos().addActionListener((ActionListener)this);
        
        this.add(panelBotones,BorderLayout.EAST);
        this.add(this.panelAlarma,BorderLayout.SOUTH);
        this.add(this.panelMedicamentos,BorderLayout.CENTER);
        
        
    };

    @Override
    public void actionPerformed(ActionEvent e) {
        if(this.panelBotones.getBtnIngresar() == e.getSource()) {
            this.ventanaIM.setVisible(true);
        }
         if(this.panelBotones.getBtnEliminar()== e.getSource()) {
            JOptionPane.showMessageDialog(null, ("Exito eliminar"));
        }
          if(this.panelBotones.getBtnVerMedicamentos()== e.getSource()) {
            JOptionPane.showMessageDialog(null, ("Exito ver detalle"));
        }
    }
}
