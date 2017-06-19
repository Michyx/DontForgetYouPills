package views;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import manager.Programa;

public class VentanaPrincipal extends JFrame implements ActionListener {

    private VentanaDetalle ventanaDetalle;
    private VentanaIngresarMedicamento ventanaIM;
    private PanelBotonesP panelBotones;
    private PanelHoraActual panelAlarma;
    private PanelMedicamentosActivos panelMedicamentos;
    private Programa programa = new Programa();
    private static final Logger LOGER = Logger.getLogger(VentanaPrincipal.class.getName());

    public VentanaPrincipal() throws FileNotFoundException {
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
        panelAlarma = new PanelHoraActual();
        panelMedicamentos = new PanelMedicamentosActivos();

        this.panelBotones.getBtnIngresar().addActionListener((ActionListener) this);
        this.panelBotones.getBtnEliminar().addActionListener((ActionListener) this);
        this.panelBotones.getBtnVerMedicamentos().addActionListener((ActionListener) this);
        this.ventanaIM.getPanelBotones().getBtnAceptar().addActionListener(this);
        this.ventanaDetalle.getBotones().getBtnExportar().addActionListener(this);
        this.add(panelBotones, BorderLayout.EAST);
        this.add(this.panelAlarma, BorderLayout.SOUTH);
        this.add(this.panelMedicamentos, BorderLayout.CENTER);
        this.panelMedicamentos.actualizar(this.programa.getInventario());

    }

    public void eliminar() {
        this.programa.getInventario().eliminarMedicamento(this.panelMedicamentos.getIndice());
        LOGER.log(Level.WARNING, "Eliminado :{0}", this.panelMedicamentos.getIndice());

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
                try {
                    eliminar();
                } catch (Exception ex) {
                    Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
                this.programa.guardar();
                this.panelMedicamentos.actualizar(this.programa.getInventario());
                this.panelMedicamentos.setIndice(this.panelMedicamentos.getIndice()-1);
                
            } else {
                this.panelMedicamentos.setIndice(0);
                JOptionPane.showMessageDialog(null, "Seleccione un medicamento");
            }

        }
        if (this.panelBotones.getBtnVerMedicamentos() == e.getSource()) {
            if (this.panelMedicamentos.getIndice() != -1) {
                this.ventanaDetalle.cargarDetalle(this.programa.getInventario().obtenerMedicamento(this.panelMedicamentos.getIndice()));
                this.ventanaDetalle.cargarTabla(this.programa.obtenerHorarios(this.panelMedicamentos.getIndice()));
                this.ventanaDetalle.setVisible(true);
                this.programa.guardar();
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione un medicamento");
            }

        }

        if (this.ventanaIM.getPanelBotones().getBtnAceptar() == e.getSource()) {
            if (this.ventanaIM.getPanelIngresar().validarTextField() == true) {
                this.programa.setInventario(this.ventanaIM.nuevoMedicamento(this.programa.getInventario()));
                this.programa.getInventario().obtenerMedicamento(this.programa.getInventario().getSize() - 1).calcularDatos();
                this.panelMedicamentos.actualizar(this.programa.getInventario());
                this.programa.guardar();
                this.ventanaIM.dispose();
                this.ventanaIM.resetTextField();
                this.programa.programarAlarmas();
            } else {
                JOptionPane.showMessageDialog(null, "Todos los campos deben estar llenos");
            }
        }
        if (this.ventanaDetalle.getBotones().getBtnExportar() == e.getSource()) {
            JOptionPane.showMessageDialog(null, "Exportando en lastExport.txt");
            this.programa.Exportar(this.panelMedicamentos.getIndice());
        }
    }
}
