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
public class VentanaIngresarMedicamento extends JFrame implements ActionListener {

    private PanelBotonesIM panelBotones;
    private PanelIngresar panelIngresar;

    public VentanaIngresarMedicamento() {

        initComponents();
    }

    private void initComponents() {
        BorderLayout distribucion = new BorderLayout();
        this.setLayout(distribucion);
        panelBotones = new PanelBotonesIM();
        panelIngresar = new PanelIngresar();

        panelBotones.getBtnAceptar().addActionListener((ActionListener) this);
        panelBotones.getBtnCancelar().addActionListener((ActionListener) this);
        this.add(this.panelIngresar, BorderLayout.CENTER);
        this.add(this.panelBotones, BorderLayout.SOUTH);
        this.setTitle("Ingresar Medicamentos");
        this.setResizable(false);
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.setSize(400, 300);
        this.setLocation(300, 300);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (this.panelBotones.getBtnAceptar() == e.getSource()) {
            JOptionPane.showMessageDialog(null, ("Exito aceptar"));
            this.setVisible(false);
        }
        if (this.panelBotones.getBtnCancelar() == e.getSource()) {
            this.setVisible(false);
            
        }
    }

}
