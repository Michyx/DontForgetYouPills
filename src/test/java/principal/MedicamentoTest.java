/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

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
   public class MedicamentoTest {

       public MedicamentoTest() {
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


       @Test(expected = NullPointerException.class)
       public void testConstructorDias(){

           Medicamento medicamento = new Medicamento("Paracetamol",Double.NaN,7.6,3.3);



       }
       @Test(expected = NullPointerException.class)
       public void testConstructorNombre(){

           Medicamento medicamento = new Medicamento(null,5.5,7.6,3.3);



       }
          @Test(expected = NullPointerException.class)
       public void testConstructorHoras(){

           Medicamento medicamento = new Medicamento("Hipoglós",5.5,7.6,Double.NaN);



       }
          @Test(expected = NullPointerException.class)
       public void testConstructorDosis(){

           Medicamento medicamento = new Medicamento("Vitamina C",5.5,Double.NaN,3.3);



       }

       @Test
       public void constructor(){
       
           Medicamento medicamento = new Medicamento("Ibuprofeno", 5, 600, 4.5);
       
       
       
       }
}
