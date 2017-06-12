/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.awt.event.ActionEvent;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import modelo.Inventario;
import modelo.Medicamento;

/**
 *
 * @author Loli Pop
 */
public class VentanaIngresarMedicamentoTest {
    
    public VentanaIngresarMedicamentoTest() {
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
     * Test of actionPerformed method, of class VentanaIngresarMedicamento.
     */
    @Test
    public void parseTextTest() {
        VentanaIngresarMedicamento ven = new VentanaIngresarMedicamento();
        Inventario inv = new Inventario();
        ven.getPanelIngresar().getIngreseDias().setText("2");
        double  esperado = Double.parseDouble(ven.getPanelIngresar().getIngreseDias().getText());
        assertEquals(esperado, 2, 0.0); 
        
        
    }

}
