
package views;

import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;



public class PanelMedicamentos extends JPanel{
    
   
    String [] detalle = {"Día","Hora"};
    Object[][] data =  {{"Lunes","13.00"},
                        {"Martes","17.00"},
                        {"Miercoles","21.00"},
                        {"Jueves","13.00"},
                        {"Viernes","17.00"},
                        {"Sábado","10.00"},
                        {"Domingo","09.00"},
                        };              
                       
    private DefaultTableModel dtm;
    public PanelMedicamentos(){
    
        initComponents();
        
    }
    
    public void initComponents(){
        
        GridLayout distribucion = new GridLayout(0,1);
        setLayout(distribucion);
        this.dtm = new DefaultTableModel(data,detalle);
        JTable table = new JTable(dtm); 

        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table.doLayout();

        this.add(table);

    }

    public void cargar(String[][] horas) {
        this.removeAll();
        this.dtm = new DefaultTableModel(horas, detalle);
        JTable table = new JTable(dtm);
        this.add(table);
        revalidate();
    }

}
