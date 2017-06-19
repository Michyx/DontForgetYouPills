package modelo;

import java.util.ArrayList;

public class ConjuntoAlarmas {

    private ArrayList<ProgramacionAlarma> alarmas;

    public ConjuntoAlarmas() {
        this.alarmas = new ArrayList<>();
    }

    public void calcularAlarmas(Inventario inventario) {
        ProgramacionAlarma nuevoMedicamento;
        for (int i = 0; i < (inventario.getSize()); i++) {
            nuevoMedicamento = new ProgramacionAlarma(inventario.obtenerMedicamento(i));
            alarmas.add(nuevoMedicamento);
            System.out.println("Añadido");
        }
    }

    public int getSize() {
        return this.alarmas.size();
    }

    public ArrayList<ProgramacionAlarma> getAlarmas() {
        return alarmas;
    }

    public String[][] obtenerhora(int indice) {
        return this.alarmas.get(indice).obtenerHorarios();
    }
}
