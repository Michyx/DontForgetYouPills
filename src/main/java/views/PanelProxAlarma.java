
package views;

import java.awt.FlowLayout;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;



public class PanelProxAlarma extends JPanel {
    private JLabel ingresar;
    private Date fecha = new Date();
    private String hora;

    public PanelProxAlarma() {
        initComponents();
    }

    private void initComponents() {
        
        FlowLayout distribucion = new FlowLayout();
        this.setLayout(distribucion);   
        JSeparator separator = new JSeparator();
        
        DateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");
        hora = (formatoHora.format(fecha));
        
        this.ingresar = new JLabel(hora);
        this.add(separator);
        this.add(this.ingresar);
        
    }
}
