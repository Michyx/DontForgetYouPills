package manager;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Inventario;
import modelo.Medicamento;

/**
 *
 * @author Loli Pop
 */
public class GestorDatos {

    private String rutaTxt;
    private String rutaJson;
    private static final Logger LOGER = Logger.getLogger(GestorDatos.class.getName());

    public GestorDatos(String rutaJ, String rutaTxt) {
        this.rutaJson = rutaJ;
        this.rutaTxt = rutaTxt;
    }

    public void almacenar(Medicamento p1) {
        FileWriter writer;
        try {
            writer = new FileWriter(this.rutaJson, true);
            Gson gson = new GsonBuilder().create();
            gson.toJson(p1, writer);
            writer.write("\r\n");
            writer.close();
        } catch (IOException e) {
            System.out.println("Error al manejar el archivo");

        }

    }

    public Inventario recuperar(Inventario inv) throws FileNotFoundException {
        System.out.println("Cargando desde : " + rutaJson);
        inv.limpiar();
        BufferedReader lector;
        Gson objJson = new Gson();
        try {
            lector = new BufferedReader(new FileReader(new File(rutaJson)));
            String linea = lector.readLine();
            while (linea != null) {
                LOGER.log(Level.INFO, "Cargando:{0} ", linea);
                Medicamento jsonMedicamento = objJson.fromJson(linea, Medicamento.class);
                inv.añadirMedicamento(jsonMedicamento);
                linea = lector.readLine();

            }
        } catch (Exception e) {
            System.out.println("Error al cargar");
        }

        return inv;
    }

    public void limpiarFichero() {

        BufferedWriter bf;
        try {
            bf = new BufferedWriter(new FileWriter(new File(rutaJson)));
            bf.close();
        } catch (IOException e) {
            System.out.println("Error al manejar el archivo");

        }
    }

    public void limpiarTxt() {

        BufferedWriter bf;
        try {
            bf = new BufferedWriter(new FileWriter(new File(rutaTxt)));
            bf.close();
        } catch (IOException e) {
            System.out.println("Error al manejar el archivo");

        }
    }

    public void escribirTxt(String[][] datos, Inventario inv, int indice) {
        limpiarTxt();

        FileWriter writer;
        try {
            writer = new FileWriter(this.rutaTxt, true);
            writer.write("Medicamento : " + inv.obtenerMedicamento(indice).getNombre() + "\r\n");
            writer.write("Cada : " + inv.obtenerMedicamento(indice).getHoras() + "\r\n");
            writer.write("Dosis : " + inv.obtenerMedicamento(indice).getDosis() + "\r\n");
            writer.write("Cantidad de dias : " + inv.obtenerMedicamento(indice).getDuracion() + "\r\n");
            writer.write("Fecha de inicio : " + inv.obtenerMedicamento(indice).getFechaInicioString() + "\r\n");
            writer.write("Fecha de termino : " + inv.obtenerMedicamento(indice).getFechaTerminoString() + "\r\n");
            writer.write("Fechas : \r\n");
            for (int i = 0; i < datos.length; i++) {
                String linea = (datos[i][0] + " | " + datos[i][1]);
                writer.write(linea);
                writer.write("\r\n");

            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Error al manejar el archivo");

        }
    }
}
