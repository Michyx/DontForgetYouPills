
package manager;

import java.io.FileNotFoundException;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Calendario;
import modelo.Inventario;
import modelo.Medicamento;
import views.VentanaIngresarMedicamento;
import views.VentanaPrincipal;

public class Programa {

    private Inventario inventario;
    private Calendario calendario;
    private GestorDatos gestor;
    private static final Logger LOGER = Logger.getLogger(Programa.class.getName());

    public Programa() throws FileNotFoundException {
        this.gestor = new GestorDatos("data\\output.json");
        this.inventario = new Inventario();
        this.calendario = new Calendario();
        cargar();
//        this.inventario.añadirMedicamento(new Medicamento("Paracetamol", 0, 0, 0));
//        this.inventario.añadirMedicamento(new Medicamento("Ibuprofeno", 0, 0, 0));
//        this.inventario.añadirMedicamento(new Medicamento("Amitriptilina", 0, 0, 0));
//        this.inventario.añadirMedicamento(new Medicamento("Hipoglós", 0, 0, 0));
        
    }
    public Inventario getInventario() {
        return this.inventario;
    }

    public void guardar() {
        gestor.limpiarFichero();
        
        for (int i = 0; i < inventario.getSize(); i++) {
            gestor.almacenar(inventario.obtenerMedicamento(i));
            LOGER.log(Level.INFO, "Guardando :{0} ",inventario.obtenerMedicamento(i));
        }

    }

    public void cargar() throws FileNotFoundException{
        this.inventario = gestor.recuperar(inventario);
    }
    
    public void setInventario(Inventario inventario) {
        this.inventario = inventario;
    }

}
