
package app;

/**
 *
 * @author Strawberry
 */

public class ArgumentoNoValido extends Exception{

    public ArgumentoNoValido() {
        
        
        
        
    }
    
    public void lanzarMensajeDosis(){
    
        System.out.println("Error, (número)dosis no válido");
    }
    
    public void lanzarMensajeNombre(){
        
        System.out.println("Error, nombre no válido");
    
    }
    
    public void lanzarMensajeDias(){
    
        System.out.println("Error, (Número)días no válido");
    }
    
    public void lanzarMensajeHoras(){
    
        System.out.println("Error, (Número)hora no válido");
    
    }

    
    
    
}
