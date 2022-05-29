/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import javax.swing.JButton;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author David
 */
public class NewClassTest {
    
    public NewClassTest() {
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
     * Test of iniciar method, of class NewClass.
     */
    @Test
    public void testIniciar() {
        System.out.println("iniciar");
        NewClass instance = null;
        instance.iniciar();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setObtener method, of class NewClass.
     */
    @Test
    public void testSetObtener() {
        System.out.println("setObtener");
        String obtener = "";
        NewClass.setObtener(obtener);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of actionPerformed method, of class NewClass.
     */
    @Test
    public void testActionPerformed() {
        System.out.println("actionPerformed");
        ActionEvent e = null;
        NewClass instance = null;
        instance.actionPerformed(e);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of estiloBoton method, of class NewClass.
     */
    @Test
    public void testEstiloBoton() {
        System.out.println("estiloBoton");
        String ruta = "";
        JButton botón = null;
        NewClass instance = null;
        instance.estiloBoton(ruta, botón);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cargarComboCategorias method, of class NewClass.
     */
    @Test
    public void testCargarComboCategorias() {
        System.out.println("cargarComboCategorias");
        NewClass instance = null;
        instance.cargarComboCategorias();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
