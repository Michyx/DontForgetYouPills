
package app;

import java.io.FileNotFoundException;
import manager.Programa;
import views.VentanaPrincipal;


public class Lanzador {
    public static void main(String[] args) throws FileNotFoundException {
        VentanaPrincipal ventana= new VentanaPrincipal();
        ventana.setVisible(true);
    }
}
