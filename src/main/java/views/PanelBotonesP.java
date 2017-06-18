
package views;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;


public class PanelBotonesP extends JPanel{
    
    private JButton btnIngresar;
    private JButton btnVerMedicamentos;
    private JButton btnEliminar;
    private Color color = new Color(173,214,229);
    private ImageIcon iconoEliminar;
    private ImageIcon iconoIngresar;
    private ImageIcon iconoDetalle;
    
    public PanelBotonesP() {
        initComponents();
    }

    private void initComponents() {
        
        GridLayout distribucion = new GridLayout(0,1);  
        setLayout(distribucion);
        
        this.btnEliminar = new JButton ("Eliminar ");
        btnEliminar.setBackground(color);
        ImageIcon iconoEliminar = new ImageIcon("resources/eliminarMedicamento.png");
        btnEliminar.setIcon(iconoEliminar);
        
        this.btnIngresar = new JButton("Ingresar");
        btnIngresar.setBackground(color);
        ImageIcon iconoIngresar = new ImageIcon("resources/agregarMedicamento.png");
        btnIngresar.setIcon(iconoIngresar);
        
        this.btnVerMedicamentos = new JButton("Detalle");
        btnVerMedicamentos.setBackground(color);
        ImageIcon iconoDetalle = new ImageIcon("resources/detalleMedicamento.png");
        btnVerMedicamentos.setIcon(iconoDetalle);
        
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
