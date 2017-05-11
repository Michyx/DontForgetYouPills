
package views;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;


public class PanelBotonesDetalle extends JPanel{
    
    
    JButton btnOk, btnExportar; 

    public JButton getBtnOk() {
        return btnOk;
    }

    public JButton getBtnExportar() {
        return btnExportar;
    }
    
    
    
    public PanelBotonesDetalle(){
    
        initComponents();
        
    }
    
    public void initComponents(){
    
        GridLayout distribucion = new GridLayout();
        this.setLayout(distribucion);
        
        btnOk = new JButton("Ok");
        this.add(btnOk);
        
        btnExportar = new JButton("Exportar");
        this.add(btnExportar);

    }

}
