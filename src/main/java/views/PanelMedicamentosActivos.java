/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.plaf.FontUIResource;
import modelo.Inventario;

/**
 *
 * @author Loli Pop
 */
public class PanelMedicamentosActivos extends JPanel implements ListSelectionListener {

    private JLabel medicamentosLabel;
    private JList listaMedicamentos;
    private int indice;
    private static final Logger LOGER = Logger.getLogger(PanelMedicamentosActivos.class.getName());

    public PanelMedicamentosActivos() {

        initComponents();

    }

    public void initComponents() {

        GridLayout distribucion = new GridLayout(0, 1);
        this.setLayout(distribucion);
        this.medicamentosLabel = new JLabel("Medicamentos Totales");
        this.add(this.medicamentosLabel);

        this.listaMedicamentos = new JList();

        this.listaMedicamentos.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        this.indice = listaMedicamentos.getSelectedIndex();

        this.add(listaMedicamentos);

    }

    public void actualizar(Inventario inventario) {

        String[] datos = new String[inventario.getSize()];
        for (int i = 0; i < inventario.getSize(); i++) {
            datos[i] = inventario.obtenerMedicamento(i).getNombre();
        }
        this.remove(this.listaMedicamentos);
        this.listaMedicamentos = new JList(datos);
        this.listaMedicamentos.addListSelectionListener((ListSelectionListener) this);
        this.add(listaMedicamentos);
        this.revalidate();

    }

    public int getIndice() {
        return indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }

    public JList getListaMedicamentos() {
        return listaMedicamentos;
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        this.indice = listaMedicamentos.getAnchorSelectionIndex();
        // System.out.println("Selected index : " + this.indice);
        LOGER.log(Level.INFO, "Indice: {0}", this.indice);

    }
}
