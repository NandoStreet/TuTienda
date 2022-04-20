/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import java.util.List;
import modelo.dto.loginDTO;
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
public class loguinDAOTest {
    
    public loguinDAOTest() {
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
    public void testRead_Object() {
      System.out.println("Test loguin");
        //Entrada de datos
        Object key = "david@gmail.com";
        Object key2 = "qwerty";
        loguinDAO instance = new loguinDAO();
        loginDTO result = instance.read(key, key2);
        //Datos esperados
        loginDTO expResult = new loginDTO(2, "david@gmail.com", "qwerty", 2);
        
        //Comparación entre salida de datos y datos esperados
        assertEquals(result.getRoles_idrol(), expResult.getRoles_idrol());
    
        
        if(!(String.valueOf(result.getRoles_idrol()).equals(String.valueOf(expResult.getRoles_idrol())))){
        fail("The test case is a prototype.");
        }
    }
    
}
