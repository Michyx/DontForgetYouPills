/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Loli Pop
 */
public class PanelIngresar extends JPanel {

    private JTextField ingreseNombre;
    private JTextField ingreseDosis;
    private JTextField ingreseDias;
    private JTextField ingreseIntervalo;

    private JLabel ingreseNombreLabel;
    private JLabel ingreseDosisLabel;
    private JLabel ingreseDiasLabel;
    private JLabel ingreseIntervaloLabel;
    
 

    public PanelIngresar() {
        initComponents();
    }

    private void initComponents() {
        GridLayout distribucion = new GridLayout(0, 1);
        this.setLayout(distribucion);
        añadirComponentes();

        this.add(this.ingreseNombreLabel);
        this.add(this.ingreseNombre);
        this.add(this.ingreseDosisLabel);
        this.add(this.ingreseDosis);
        this.add(this.ingreseDiasLabel);
        this.add(this.ingreseDias);
        this.add(this.ingreseIntervaloLabel);
        this.add(this.ingreseIntervalo);
    }

    private void añadirComponentes() {

        this.ingreseNombre = new JTextField();
        this.ingreseDosis = new JTextField();
        this.ingreseDias = new JTextField();
        this.ingreseIntervalo = new JTextField();

        this.ingreseNombreLabel = new JLabel("Ingrese el nombre del medicamento");
        this.ingreseDosisLabel = new JLabel("Ingrese la dosis del medicamento en mg");
        this.ingreseDiasLabel = new JLabel("Ingrese la duracion del tratamiento en dias");
        this.ingreseIntervaloLabel = new JLabel("Ingrese el intervalo de horas");

    }

    public JTextField getIngreseNombre() {
        return ingreseNombre;
    }

    public JTextField getIngreseDosis() {
        return ingreseDosis;
    }

    public JTextField getIngreseDias() {
        return ingreseDias;
    }

    public JTextField getIngreseIntervalo() {
        return ingreseIntervalo;
    }
    
    
}
