/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

/**
 *
 * @author Loli Pop
 */
public class Medicamento {

    private String nombre;
    private double duracion;
    private double dosis;
    private double horas;

    public Medicamento(String nombre, double dias, double dosis, double horas) {
        
        if(nombre != null){
         this.nombre = nombre;
        }else{
            throw new NullPointerException("Nombre nulo");
        }
        
        if(!Double.isNaN(dias)){
        this.duracion = dias;
        }else{
            throw new NullPointerException("Días nulo");
        }
        
        if(!Double.isNaN(dosis)){
        this.dosis = dosis;   
            
        }else{
            throw new NullPointerException("Dosis nulo");
        }
        
        if(!Double.isNaN(horas)){
        this.horas = horas;    
        }else{
            throw new NullPointerException("horas nulo");
        }
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

    public double getHoras() {
        return horas;
    }
    
    
}
