package views;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelBotonesDetalle extends JPanel {

    private JButton btnOk, btnExportar;
    private Color color = new Color(173, 214, 229);
    private ImageIcon iconoOk, iconoExportar;

    public PanelBotonesDetalle() {

        initComponents();

    }

    public void initComponents() {

        GridLayout distribucion = new GridLayout();
        this.setLayout(distribucion);

        this.btnOk = new JButton("Ok");
        btnOk.setBackground(color);
        ImageIcon iconoOk = new ImageIcon("resources/botonAceptar.png");
        btnOk.setIcon(iconoOk);

        this.btnExportar = new JButton("Exportar");
        btnExportar.setBackground(color);
        ImageIcon iconoExportar = new ImageIcon("resources/botonExportar.png");
        btnExportar.setIcon(iconoExportar);

        this.add(btnOk);
        this.add(btnExportar);

    }

    public JButton getBtnOk() {
        return btnOk;
    }

    public JButton getBtnExportar() {
        return btnExportar;
    }

}
