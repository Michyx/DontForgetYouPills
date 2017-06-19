package modelo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Medicamento {

    private String nombre;
    private double duracion;
    private double dosis;
    private double horas;
    private double dosisTotal;
    private double horasRestantes;
    private double cantidadDosis;

    private Date fechaInicio;
    private Date fechaTermino;

    public Medicamento(String nombre, double dias, double dosis, double horas, Date fechaActual) {

        if (nombre != null) {
            this.nombre = nombre;
        } else {
            throw new NullPointerException("Nombre nulo");
        }

        if (!Double.isNaN(dias)) {
            this.duracion = dias;
        } else {
            throw new NullPointerException("Días nulo");
        }

        if (!Double.isNaN(dosis)) {
            this.dosis = dosis;

        } else {
            throw new NullPointerException("Dosis nulo");
        }

        if (!Double.isNaN(horas)) {
            this.horas = horas;
        } else {
            throw new NullPointerException("horas nulo");
        }
        this.fechaInicio = fechaActual;
    }

    public String getFechaInicioString() {
        SimpleDateFormat formateador = new SimpleDateFormat("'Dia' : dd 'de' MMMM 'de' yyyy '/Hora' HH : mm : ss", new Locale("es_ES"));
        String fecha = formateador.format(fechaInicio.getTime());
        return fecha;

    }

    public String getFechaTerminoString() {
        SimpleDateFormat formateador = new SimpleDateFormat("'Dia' : dd 'de' MMMM 'de' yyyy '/Hora' HH : mm : ss", new Locale("es_ES"));
        String fecha = formateador.format(fechaTermino.getTime());
        return fecha;

    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public String getNombre() {
        return nombre;
    }

    public double getDuracion() {
        return duracion;
    }

    public double getDosis() {
        return dosis;
    }

    public void setFechaTermino(Date fechaTermino) {
        this.fechaTermino = fechaTermino;
    }

    public double getHoras() {
        return horas;
    }

    public double getHorasRestantes() {
        return horasRestantes;
    }

    public Date getFechaTermino() {
        return fechaTermino;
    }

    public double getCantidadDosis() {
        return cantidadDosis;
    }

    public double getDosisTotal() {
        return dosisTotal;
    }

    public void calcularDatos() {
        this.horasRestantes = this.getDuracion() * 24;
        this.cantidadDosis = this.horasRestantes / this.horas;
        this.dosisTotal = this.cantidadDosis * this.dosis;
    }

    public void setHorasRestantes(double horasRestantes) {
        this.horasRestantes = horasRestantes;
    }

    @Override

    public String toString() {
        return "Medicamento{" + "nombre=" + nombre + ", duracion=" + duracion + ", dosis=" + dosis + ", horas=" + horas + ", dosisTotal=" + dosisTotal + ", horasRestantes=" + horasRestantes + '}';
    }

}
