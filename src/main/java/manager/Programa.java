
package modelo;



public class Programa {
    
    private Inventario inventario;
    private Calendario calendario;
    private Alarma alarma; 

    
    public Programa() {
        this.inventario = new Inventario();
        this.calendario = new Calendario();
        this.alarma = new Alarma();
        this.inventario.añadirMedicamento(new Medicamento("Paracetamol", 0, 0, 0));
        this.inventario.añadirMedicamento(new Medicamento("Ibuprofeno", 0, 0, 0));
        this.inventario.añadirMedicamento(new Medicamento("Amitriptilina", 0, 0, 0));
        this.inventario.añadirMedicamento(new Medicamento("Hipoglós", 0, 0, 0));
        
        
    }
    public Inventario getInventario() {
        return this.inventario;
    }

    public void setInventario(Inventario inventario) {
        this.inventario = inventario;
    }
    
    

}
