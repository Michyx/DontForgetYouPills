package views;

import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class PanelMedicamentos extends JPanel {

    String[] detalle = {"Día", "Hora"};
    Object[][] data = null;

    private DefaultTableModel dtm;

    public PanelMedicamentos() {

        initComponents();

    }

    public void initComponents() {

        setLayout(new GridLayout());

        this.dtm = new DefaultTableModel(data, detalle);
        JTable table = new JTable(dtm);
        table.setPreferredScrollableViewportSize(new Dimension(50, 50));
        table.setFillsViewportHeight(false);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table.doLayout();

        JScrollPane js = new JScrollPane(table);
        js.setVisible(true);
        // add(js);
        this.add(table);

    }

    public void cargar(String[][] horas) {

        this.removeAll();
        this.dtm = new DefaultTableModel(horas, detalle);
        JTable table = new JTable(dtm);
        table.setPreferredScrollableViewportSize(new Dimension(60, 60));
        table.setFillsViewportHeight(false);

        //table.doLayout();
        JScrollPane js = new JScrollPane(table);
        js.setVisible(true);
        //table.add(js);
        this.add(table);
        revalidate();
    }

}
