
package manager;

import java.io.FileNotFoundException;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Calendario;
import modelo.ConjuntoAlarmas;
import modelo.Inventario;
import modelo.Medicamento;
import modelo.ProgramacionAlarma;
import views.VentanaIngresarMedicamento;
import views.VentanaPrincipal;

public class Programa {

    private Inventario inventario;
    private Calendario calendario;
    private GestorDatos gestor;
    private ConjuntoAlarmas alarmas;
    private static final Logger LOGER = Logger.getLogger(Programa.class.getName());

    public Programa() throws FileNotFoundException {
        this.gestor = new GestorDatos("data\\output.json");
        this.inventario = new Inventario();
        this.calendario = new Calendario();
        this.alarmas = new ConjuntoAlarmas();
        cargar();
        programarAlarmas();
        
    }
    public Inventario getInventario() {
        return this.inventario;
    }
    public void programarAlarmas() {
        alarmas.calcularAlarmas(inventario);
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
    public String[][] obtenerHorarios(int indice){
    return alarmas.obtenerhora(indice);
   
    }
    
}
