/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Inventario;
import modelo.Medicamento;

/**
 *
 * @author Loli Pop
 */
public class GestorDatos {

    private String ruta;
    private static final Logger LOGER = Logger.getLogger(GestorDatos.class.getName());

    public GestorDatos(String ruta) {
        this.ruta = ruta;
    }

    public void almacenar(Medicamento p1) {
        FileWriter writer;
        try {
            writer = new FileWriter(this.ruta, true);
            Gson gson = new GsonBuilder().create();
            gson.toJson(p1, writer);
            writer.write("\r\n");
            writer.close();
        } catch (IOException e) {
            System.out.println("Error al manejar el archivo");

        }

    }

    public Inventario recuperar(Inventario inv) throws FileNotFoundException {
        System.out.println("Cargando desde : " + ruta);
        inv.limpiar();
        BufferedReader lector;
        Gson objJson = new Gson();
        try {
            lector = new BufferedReader(new FileReader(new File(ruta)));
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
            bf = new BufferedWriter(new FileWriter(new File(ruta)));
            bf.close();
        } catch (IOException e) {
            System.out.println("Error al manejar el archivo");

        }
    }
}
