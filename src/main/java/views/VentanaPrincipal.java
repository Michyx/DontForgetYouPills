
package views;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import modelo.Programa;



public class VentanaPrincipal extends JFrame implements ActionListener {

    private VentanaDetalle ventanaDetalle;
    private VentanaIngresarMedicamento ventanaIM;
    private PanelBotonesP panelBotones;
    private PanelProxAlarma panelAlarma;
    private PanelMedicamentosActivos panelMedicamentos;
    private Programa programa = new Programa();

    private static final Logger LOGER = Logger.getLogger(VentanaPrincipal.class.getName());

    public VentanaPrincipal() {
        programa = new Programa();
        initComponents();
    }

    private void initComponents() {
        ventanaDetalle = new VentanaDetalle();
        ventanaIM = new VentanaIngresarMedicamento();
        añadirComponentes();

        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Ventana Principal");
        this.setSize(400, 300);
    }

    private void añadirComponentes() {

        panelBotones = new PanelBotonesP();
        panelAlarma = new PanelProxAlarma();
        panelMedicamentos = new PanelMedicamentosActivos();

        this.panelBotones.getBtnIngresar().addActionListener((ActionListener) this);
        this.panelBotones.getBtnEliminar().addActionListener((ActionListener) this);
        this.panelBotones.getBtnVerMedicamentos().addActionListener((ActionListener) this);
        this.ventanaIM.getPanelBotones().getBtnAceptar().addActionListener(this);

        this.add(panelBotones, BorderLayout.EAST);
        this.add(this.panelAlarma, BorderLayout.SOUTH);
        this.add(this.panelMedicamentos, BorderLayout.CENTER);
        this.panelMedicamentos.actualizar(this.programa.getInventario());

    }

    public void eliminar() {
        this.programa.getInventario().eliminarMedicamento(this.panelMedicamentos.getIndice());
      //System.out.println(this.panelMedicamentos.getIndice());
        LOGER.log(Level.WARNING,"Eliminado :{0}",this.panelMedicamentos.getIndice());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (this.panelBotones.getBtnIngresar() == e.getSource()) {
            this.ventanaIM.setVisible(true);

        }
        if (this.panelBotones.getBtnEliminar() == e.getSource()) {
            if (this.panelMedicamentos.getIndice() != -1) {
                System.out.println("Eliminando...");
                System.out.println(this.programa.getInventario().obtenerMedicamento(this.panelMedicamentos.getIndice()).getNombre());
                eliminar();
                this.panelMedicamentos.actualizar(this.programa.getInventario());
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione un medicamento");
            }

        }
        if (this.panelBotones.getBtnVerMedicamentos() == e.getSource()) {
            if (this.panelMedicamentos.getIndice() != -1) {
                this.ventanaDetalle.cargarDetalle(this.programa.getInventario().obtenerMedicamento(this.panelMedicamentos.getIndice()));
                this.ventanaDetalle.setVisible(true);
                this.panelMedicamentos.setIndice(-1);
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione un medicamento");
            }

        }

        if (this.ventanaIM.getPanelBotones().getBtnAceptar() == e.getSource()) {
            if (this.ventanaIM.getPanelIngresar().validarTextField() == true) {
                this.programa.setInventario(this.ventanaIM.nuevoMedicamento(this.programa.getInventario()));
                this.panelMedicamentos.actualizar(this.programa.getInventario());
                
               //LOGER.log(Level.INFO,"Medicamento nuevo:{0} ", this.programa.getInventario().obtenerMedicamento(this.panelMedicamentos.getIndice()).toString());
                
                this.ventanaIM.dispose();
                this.ventanaIM.resetTextField();
            } else {
                JOptionPane.showMessageDialog(null, "Todos los campos deben estar llenos");
            }
        }
    }
}
