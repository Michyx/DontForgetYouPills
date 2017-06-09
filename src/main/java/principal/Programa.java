/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import java.util.Objects;
import views.VentanaPrincipal;

/**
 *
 * @author Loli Pop
 */
public class Programa {
    private Inventario inventario;
    private Calendario calendario;
    public Programa() {
        this.inventario = new Inventario();
        this.calendario = new Calendario();
        this.inventario.añadirMedicamento(new Medicamento("Paracetamol", 0, 0, 0));
        this.inventario.añadirMedicamento(new Medicamento("Paracetamol2", 0, 0, 0));
        this.inventario.añadirMedicamento(new Medicamento("Paracetamol3", 0, 0, 0));
        
    }

    public Inventario getInventario() {
        return this.inventario;
    }

    public void setInventario(Inventario inventario) {
        this.inventario = inventario;
    }




   

}
