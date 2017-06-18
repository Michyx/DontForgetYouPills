
package views;

import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;


public class PanelBotonesIM extends JPanel{
    
     private JButton btnAceptar;
     private JButton btnCancelar;
     private Color color = new Color(173,214,229);
     private ImageIcon iconoAceptar, iconoCancelar;
     
    public PanelBotonesIM() {
        initComponents();
    }

    private void initComponents() {
        FlowLayout distribucion = new FlowLayout();
        
        this.btnAceptar = new JButton("Aceptar");
        btnAceptar.setBackground(color);
        ImageIcon iconoAceptar = new ImageIcon("resources/botonAceptar.png");
        btnAceptar.setIcon(iconoAceptar);
        
        
        this.btnCancelar = new JButton("Cancelar");
        btnCancelar.setBackground(color);
        ImageIcon iconoCancelar = new ImageIcon("resources/botonCancelar.png");
        btnCancelar.setIcon(iconoCancelar);
        
        this.add(btnAceptar);
        this.add(btnCancelar);
    }

    public JButton getBtnAceptar() {
        return btnAceptar;
    }

    public JButton getBtnCancelar() {
        return btnCancelar;
    }
     
     
     
}
