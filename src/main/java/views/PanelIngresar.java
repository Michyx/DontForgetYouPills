/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

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

    public boolean validarTextField() {
        boolean validacion = true;
        if (this.ingreseDias.getText().equals("") || this.ingreseDosis.getText().equals("")
                || this.ingreseIntervalo.getText().equals("") || this.ingreseNombre.getText().equals("")) {
            validacion = false;
        }
        return validacion;
    }

    public boolean validarHoras(double desde, double hasta) {
        double horas = 0;
        boolean error = false;

        error = false;
        try {
            horas = Integer.parseInt(this.ingreseIntervalo.getText());

        } catch (Exception e) {
            error = true;
            JOptionPane.showMessageDialog(null, "Horas no validas", "Error", JOptionPane.ERROR_MESSAGE);
        }
        if (horas < desde || horas > hasta) {
            JOptionPane.showMessageDialog(null, "Se permite desde " + desde + " hasta " + hasta + " horas");
            error = true;
        }

        return error;
    }

    public boolean validarDosis(double desde, double hasta) {
        double dosis = 0;
        boolean error = false;

        error = false;
        try {
            dosis = Integer.parseInt(this.ingreseDosis.getText());

        } catch (Exception e) {
            error = true;
            JOptionPane.showMessageDialog(null, "Dosis no valida", "Error", JOptionPane.ERROR_MESSAGE);
        }
        if (dosis < desde || dosis > hasta) {
            JOptionPane.showMessageDialog(null, "Se permite desde " + desde + " hasta " + hasta + " mg");
            error = true;
        }

        return error;
    }

    public boolean validarDias(double desde, double hasta) {
        double dias = 0;
        boolean error = false;

        error = false;
        try {
            dias = Integer.parseInt(this.ingreseDias.getText());

        } catch (Exception e) {
            error = true;
            JOptionPane.showMessageDialog(null, "Dias no validos", "Error", JOptionPane.ERROR_MESSAGE);
        }
        if (dias < desde || dias > hasta) {
            JOptionPane.showMessageDialog(null, "Se permite desde " + desde + " hasta " + hasta + " dias");
            error = true;
        }

        return error;
    }

    public boolean validarNombre(int hasta) {
        String nombre = "";
        boolean error = false;

        error = false;
        try {
            nombre = this.ingreseNombre.getText();

        } catch (Exception e) {
            error = true;
            System.out.println("Nombre no valido");
        }
        if (nombre.length() > hasta) {
            JOptionPane.showMessageDialog(null, "Maximo " + hasta + " caracteres");
            error = true;
        }

        return error;
    }
}
