/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import javax.swing.JFrame;

/**
 *
 * @author Loli Pop
 */
public class VentanaIngresarMedicamento extends JFrame {

    private PanelBotonesIM panelBotones;
    private PanelIngresar panelIngresar;
    
    
    public VentanaIngresarMedicamento() {
        
        initComponents();
    }

    private void initComponents() {
        panelBotones = new PanelBotonesIM();
        panelIngresar = new PanelIngresar();
       this.setTitle("Ingresar Medicamentos");
       this.setSize(400,300);
    }

}
