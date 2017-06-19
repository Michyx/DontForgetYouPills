package modelo;

import java.util.ArrayList;

public class Inventario {

    private ArrayList<Medicamento> medicamentos;

    public Inventario() {
        this.medicamentos = new ArrayList<>();
    }

    public boolean añadirMedicamento(Medicamento nuevoMedicamento) throws NullPointerException {

        if (nuevoMedicamento != null) {
            return this.medicamentos.add(nuevoMedicamento);
        } else {
            throw new NullPointerException("Parametro medicamento nulo");
        }

    }

    public Medicamento obtenerMedicamento(int index) throws NullPointerException {
        if (medicamentos.get(index) != null) {
            return medicamentos.get(index);
        } else {
            throw new NullPointerException("No encontrado");
        }

    }

    public void eliminarMedicamento(int indice) {

        this.medicamentos.remove(indice);

    }

    public void limpiar() {
        this.medicamentos.clear();

    }

    @Override

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }

        return true;
    }

    public int getSize() {
        return this.medicamentos.size();
    }
}
