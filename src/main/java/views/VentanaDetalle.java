
package views;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;


public class VentanaDetalle extends JFrame implements ActionListener{
    
   PanelBotonesDetalle botones;  
   PanelMedicamentos horarios; 
   PanelInformacion detalle;
    
    public VentanaDetalle(){
    
        initComponents();
        
    }
    
    public void initComponents(){
    
        
        BorderLayout distribucion = new BorderLayout();
        setLayout(distribucion);
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(700, 400);

        this.setLocation(0,0);
        this.setTitle("Detalle Medicamentos");
        
        this.botones = new PanelBotonesDetalle();
        this.horarios = new PanelMedicamentos();
        this.detalle = new PanelInformacion();

        this.add(botones, BorderLayout.SOUTH);
        this.add(horarios, BorderLayout.CENTER);
        this.add(detalle, BorderLayout.NORTH);
         
        this.botones.getBtnOk().addActionListener((ActionListener) this);
        this.botones.getBtnExportar().addActionListener((ActionListener) this);
        
        this.setResizable(false);
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        
        
        
        
   
    
    
    }
    
     public void actionPerformed(ActionEvent e) {
        if (this.botones.getBtnOk() == e.getSource()) {
            setVisible(false);
            
        }
        if (this.botones.getBtnExportar() == e.getSource()) {
            JOptionPane.showMessageDialog(null,"Exportando...");
        }
     
    }    
    
}
