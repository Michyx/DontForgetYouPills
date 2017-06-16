
package modelo;

import java.util.Calendar;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import views.Sonido;
import javax.swing.JOptionPane;

public class ProgramacionHora extends TimerTask{

  
    Sonido sonido;

    @Override
    public void run() {
        
        try {
            Calendar diaActual = Calendar.getInstance();
            
            switch(diaActual.get(Calendar.DAY_OF_WEEK)){
                
                case 1: sonido.play();/*
                        apagarAlarma();
                        break;*/
                
                case 2: sonido.play();/*
                        apagarAlarma();
                        break;*/
                
                case 3: sonido.play();/*
                        apagarAlarma();
                        break;*/
                
                case 4: sonido.play();/*
                        apagarAlarma();
                        break;*/
                
                case 5: sonido.play();/*
                        apagarAlarma();
                        break;*/
                
                case 6: sonido.play();/*
                        apagarAlarma();
                        break;*/
                
                case 7: sonido.play();/*
                        apagarAlarma();
                        break;*/
                
            }
        } catch (Exception ex) {
            Logger.getLogger(ProgramacionHora.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
 
    
    
    public void apagarAlarma() throws Exception{

        int confirmado = JOptionPane.showConfirmDialog(null,"¿Apagar?");
                       if(JOptionPane.OK_OPTION == confirmado){
                           sonido.stop();
                       }
    }
    

    
    
}
