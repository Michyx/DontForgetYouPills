/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;

/**
 *
 * @author Loli Pop
 */
public class PanelMedicamentosActivos extends JPanel {
     
    private JLabel medicamentosLabel;
    String [] datos = {"Ibuprofeno","Amitriptilina","Vitamina C","Hipoglós"};

    
    
    public PanelMedicamentosActivos(){
        
        initComponents();
    
    
    }
    
    
    public void initComponents(){

        
         GridLayout distribucion = new GridLayout(0,1);
        this.setLayout(distribucion);
        
        medicamentosLabel = new JLabel("Medicamentos Totales");  
        this.add(this.medicamentosLabel);
        
        JList lista = new JList(datos);
     
        lista.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        this.add(lista);
        
        
        
 


    }
    
    
    
}
