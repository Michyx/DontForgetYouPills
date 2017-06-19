package views;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import modelo.Inventario;
import modelo.Medicamento;
import app.ArgumentoNoValido;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VentanaIngresarMedicamento extends JFrame implements ActionListener {

    private PanelBotonesIM panelBotones;
    private PanelIngresar panelIngresar;
    private boolean ingresar;
    private ArgumentoNoValido ArgumentoNoValido;
    private static final Logger LOGER = Logger.getLogger(VentanaIngresarMedicamento.class.getName());

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

        if (this.panelBotones.getBtnCancelar() == e.getSource()) {
            this.resetTextField();
            this.dispose();
        }
    }

    public PanelIngresar getPanelIngresar() {
        return panelIngresar;
    }

    public PanelBotonesIM getPanelBotones() {
        return panelBotones;
    }

    public Inventario nuevoMedicamento(Inventario inventario) {

        String nombre = null;
        double dosis = 0;
        double dias = 0;
        double intervalo = 0;

        try {
            if (panelIngresar.validarDosis(0, 800) == false) {
                dosis = (Double.parseDouble(panelIngresar.getIngreseDosis().getText()));
            } else {
                panelIngresar.getIngreseDosis().setText("");
                throw new ArgumentoNoValido();
            }
            if (panelIngresar.validarDias(1, 360) == false) {

                dias = (Double.parseDouble(panelIngresar.getIngreseDias().getText()));
            } else {
                panelIngresar.getIngreseDias().setText("");
                throw new ArgumentoNoValido();
            }
            if (panelIngresar.validarHoras(1, 24) == false) {
                intervalo = (Double.parseDouble(panelIngresar.getIngreseIntervalo().getText()));
            } else {
                panelIngresar.getIngreseIntervalo().setText("");
                throw new ArgumentoNoValido();
            }
            if (panelIngresar.validarNombre(30) == false) {
                nombre = this.panelIngresar.getIngreseNombre().getText();
            } else {
                panelIngresar.getIngreseNombre().setText("");
                throw new ArgumentoNoValido();
            }

        } catch (ArgumentoNoValido e) {
        }

        Calendar fecha = new GregorianCalendar();
        Date fechaInicio = new Date();
        fechaInicio = fecha.getTime();
        LOGER.log(Level.INFO, "Medicamento nuevo:{0} ", new Medicamento(nombre, dias, dosis, intervalo, fechaInicio));
        inventario.añadirMedicamento(new Medicamento(nombre, dias, dosis, intervalo, fechaInicio));
        System.out.println("Tamaño del inventario: " + inventario.getSize());

        return inventario;
    }

    public boolean isIngresar() {
        return ingresar;
    }

    public void setIngresar(boolean ingresar) {
        this.ingresar = ingresar;
    }

    public void resetTextField() {
        this.panelIngresar.getIngreseDias().setText("");
        this.panelIngresar.getIngreseDosis().setText("");
        this.panelIngresar.getIngreseNombre().setText("");
        this.panelIngresar.getIngreseIntervalo().setText("");
    }
}
