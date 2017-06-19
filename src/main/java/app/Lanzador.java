
package app;

import java.io.FileNotFoundException;
import views.VentanaPrincipal;


public class Lanzador {
    public static void main(String[] args) throws FileNotFoundException, Exception {
        VentanaPrincipal ventana= new VentanaPrincipal();
        ventana.setVisible(true);
       
    }
}
