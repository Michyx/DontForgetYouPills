package views;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelInformacion extends JPanel {

    JLabel nombre, dosis, cada, inicio, termino, total;

    public PanelInformacion() {

        initComponents();

    }

    public void initComponents() {

        GridLayout distribucion = new GridLayout(3, 2); //Filas, columnas 
        setLayout(distribucion);

        nombre = new JLabel("Nombre: N/A");
        dosis = new JLabel("Dosis (mg): N/A");
        cada = new JLabel("Cada: N/A");
        inicio = new JLabel("Fecha Inicio: N/A");
        termino = new JLabel("Fecha término: N/A");
        total = new JLabel("Dosis total: N/A");

        this.add(nombre);
        this.add(cada);
        this.add(dosis);
        this.add(total);
        this.add(inicio);
        this.add(termino);

    }

    public JLabel getNombre() {
        return nombre;
    }

    public JLabel getDosis() {
        return dosis;
    }

    public JLabel getCada() {
        return cada;
    }

    public JLabel getInicio() {
        return inicio;
    }

    public JLabel getTermino() {
        return termino;
    }

    public JLabel getTotal() {
        return total;
    }

}
