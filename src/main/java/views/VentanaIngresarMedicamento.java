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
import principal.Inventario;
import principal.Medicamento;
import app.ArgumentoNoValido;

/**
 *
 * @author Loli Pop
 */
public class VentanaIngresarMedicamento extends JFrame implements ActionListener {

    private PanelBotonesIM panelBotones;
    private PanelIngresar panelIngresar;
    private boolean ingresar;
    private ArgumentoNoValido ArgumentoNoValido;
    
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
            ingresar = true;
            this.setVisible(false);
            
        }
        if (this.panelBotones.getBtnCancelar() == e.getSource()) {
            this.setVisible(false);
            ingresar = false;
        }
    }

    public PanelIngresar getPanelIngresar() {
        return panelIngresar;
    }

    public PanelBotonesIM getPanelBotones() {
        return panelBotones;
    }
    
    
    public Inventario nuevoMedicamento(Inventario inventario){
      
        String nombre = null;
        double dosis = 0;
        double dias = 0;
        double intervalo = 0;
        
        try {
             if(!Double.isNaN((Double.parseDouble(this.panelIngresar.getIngreseDosis().getText())))){    
                    dosis = (Double.parseDouble(panelIngresar.getIngreseDosis().getText()));
             }else{
             throw new ArgumentoNoValido();
             } 
             if(!Double.isNaN((Double.parseDouble(this.panelIngresar.getIngreseDias().getText())))){
                    dias = (Double.parseDouble(panelIngresar.getIngreseDias().getText()));
             }else{
             throw new ArgumentoNoValido();    
             }
             if(!Double.isNaN((Double.parseDouble(this.panelIngresar.getIngreseIntervalo().getText())))){
                    intervalo = (Double.parseDouble(panelIngresar.getIngreseIntervalo().getText()));
             }else{
             throw new ArgumentoNoValido();
             }
             if(this.panelIngresar.getIngreseNombre().getText()!=null){
                    nombre = this.panelIngresar.getIngreseNombre().getText();
             }else{
             throw new ArgumentoNoValido();
             }
             
        } catch (ArgumentoNoValido e) {
           e.lanzarMensajeDosis();
        
        
        }
 
        inventario.añadirMedicamento(new Medicamento(nombre,dias,dosis,intervalo));
    
    return inventario;
    }

    
    public boolean isIngresar() {
        return ingresar;
    }

    public void setIngresar(boolean ingresar) {
        this.ingresar = ingresar;
    }
    
}
