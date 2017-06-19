package manager;

import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Alarma;
import modelo.ConjuntoAlarmas;
import modelo.Inventario;

public class Programa {

    private Inventario inventario;
    private Alarma alarma = null;
    private GestorDatos gestor;
    private ConjuntoAlarmas alarmas;
    private static final Logger LOGER = Logger.getLogger(Programa.class.getName());

    public Programa() throws FileNotFoundException {
        this.gestor = new GestorDatos("data\\output.json", "data\\lastExport.txt");
        this.inventario = new Inventario();
        cargar();
        programarAlarmas();
        nuevaAlarma();

    }

    public Inventario getInventario() {
        return this.inventario;
    }

    public void programarAlarmas() {
        this.alarmas = new ConjuntoAlarmas();
        alarmas.calcularAlarmas(inventario);
    }

    public void guardar() {
        gestor.limpiarFichero();

        for (int i = 0; i < inventario.getSize(); i++) {
            gestor.almacenar(inventario.obtenerMedicamento(i));
            LOGER.log(Level.INFO, "Guardando :{0} ", inventario.obtenerMedicamento(i));
        }

    }

    public void nuevaAlarma() {

        if (this.alarma == null) {
            this.alarma = new Alarma(this.alarmas, this.inventario);
        } else {

            this.alarma.terminarHilo();
            this.alarma = new Alarma(this.alarmas, this.inventario);
        }
    }

    public void cargar() throws FileNotFoundException {
        this.inventario = gestor.recuperar(inventario);
    }

    public void setInventario(Inventario inventario) {
        this.inventario = inventario;
        nuevaAlarma();
    }

    public String[][] obtenerHorarios(int indice) {
        return alarmas.obtenerhora(indice);

    }

    public void Exportar(int indice) {
        gestor.escribirTxt(obtenerHorarios(indice), this.inventario, indice);
    }

}
