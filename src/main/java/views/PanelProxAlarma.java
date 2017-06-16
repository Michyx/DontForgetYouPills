
package views;

import java.awt.FlowLayout;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JLabel;



public class PanelProxAlarma extends JPanel {
    private JLabel ingresar;
    private String hora; 
    private Date fecha = new Date();
    
    public PanelProxAlarma() {
        initComponents();
    }

    private void initComponents() {
        
        FlowLayout distribucion = new FlowLayout();
        this.setLayout(distribucion);   
        JSeparator separator = new JSeparator();
        
        DateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");
        hora = formatoHora .format(fecha);
        
        this.ingresar = new JLabel(hora);
        this.add(separator);
        this.add(this.ingresar);
        
    }
}
