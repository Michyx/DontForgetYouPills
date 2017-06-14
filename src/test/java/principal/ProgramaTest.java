/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import modelo.Programa;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import modelo.Inventario;
/**
 *
 * @author Strawberry
 */
public class ProgramaTest {
    
    public ProgramaTest() {
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

  
    @Test
    public void testEqualsInventario() {
     Programa p = new Programa();
     Inventario i = new Inventario();
        assertEquals(p.getInventario(),i );

    }

    
}