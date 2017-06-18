/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import java.util.Calendar;
import java.util.GregorianCalendar;
import modelo.Inventario;
import modelo.Medicamento;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Strawberry
 */
public class InventarioTest {
    
    public InventarioTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of añadirMedicamento method, of class Inventario.
     */
    @Test
    public void añadirMedicamentoTest(){
        Inventario i = new Inventario();
        int tamañoEsperado = 3;
        Calendar fecha = new GregorianCalendar();
        i.añadirMedicamento(new Medicamento("Naproxeno", 0, 0, 0,fecha));
        i.añadirMedicamento(new Medicamento("Naproxeno mas caro", 0, 0, 0,fecha));
        i.añadirMedicamento(new Medicamento("Naproxeno Barato", 0, 0, 0,fecha));
        
        assertEquals(tamañoEsperado, i.getSize());
    }
    
    

}
