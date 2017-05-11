
package views;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class PanelInformacion extends JPanel{
    
    JLabel nombre,dosis,cada,inicio,termino,total;
    
    public PanelInformacion(){
    
        initComponents();
        
    }
    
    public void initComponents(){
    
        GridLayout distribucion = new GridLayout(3,2); //Filas, columnas 
        setLayout(distribucion);
        
        nombre = new JLabel("Nombre: Ibuprofeno");
        dosis = new JLabel("Dosis (mg): 400 mg");
        cada = new JLabel("Cada: 4 horas");
        inicio = new JLabel("Fecha Inicio: 11/04/2017");
        termino = new JLabel("Fecha término: 18/04/2017");
        total = new JLabel("Dosis total: 8400 mg");
 
        this.add(nombre);
        this.add(dosis);
        this.add(cada);
        this.add(inicio);
        this.add(termino);
        this.add(total);
    
    }
    
}
