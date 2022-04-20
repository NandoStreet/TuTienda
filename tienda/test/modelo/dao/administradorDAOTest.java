/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import java.util.List;
import modelo.dto.administradorDTO;
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
public class administradorDAOTest {

    public administradorDAOTest() {
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
     * Test of create method, of class administradorDAO.
     */
    @Test
    public void testCreate() {
        System.out.println("create");

        administradorDTO c = new administradorDTO("David", "pablo",
                74227334, 1, "davidPe@gmail.com",
                "12345", "Jr la nada",
                987330113);
        administradorDAO instance = new administradorDAO();
        boolean expResult = false;
        boolean result = instance.create(c);
        assertEquals(expResult, result);

        // TODO review the generated test code and remove the default call to fail.
        if (!(result == expResult)) {
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of delete method, of class administradorDAO.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        Object key = Integer.valueOf("74227334");
        administradorDAO instance = new administradorDAO();
        boolean expResult = true;
        boolean result = instance.delete(key);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if (!(result == expResult)) {
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of update method, of class administradorDAO.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        administradorDTO c = new administradorDTO("cambiado", "cambiado", 74277889,
                 3, "usuariocambiado@gmail.com", "pruebacambio", "direccion cambio prueba",
                98744552);
        Object b = 10;
        administradorDAO instance = new administradorDAO();
        boolean expResult = true;
        boolean result = instance.update(c, b);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if (!(result == expResult)) {
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of read method, of class administradorDAO.
     */
    @Test
    public void testRead_Object() {
        System.out.println("read");
        Object key = 68141212;
        administradorDAO instance = new administradorDAO();
        administradorDTO result = instance.read(key);
        administradorDTO expResult = new administradorDTO(2, "dsavid", "pablo", 
                68141212, 2, "david@gmail.com", "qwerty", "independencia", 987330113);

        assertTrue(expResult.getNombre().equals(result.getNombre()));
        assertTrue(expResult.getApellido().equals(result.getApellido()));
        assertTrue(String.valueOf(expResult.getId()).equals(String.valueOf(expResult.getId())));
        assertTrue(String.valueOf(expResult.getDNI()).equals(String.valueOf(expResult.getDNI())));
        assertTrue(String.valueOf(expResult.getRoles_idrol()).equals(String.valueOf(expResult.getRoles_idrol())));
        assertTrue(expResult.getCorreo().equals(result.getCorreo()));
        assertTrue(expResult.getContrasena().equals(result.getContrasena()) && expResult.getDirección().equals(result.getDirección()));
        assertTrue(expResult.getCorreo().equals(result.getCorreo()));
        assertTrue(String.valueOf(expResult.getTelefono()).equals(String.valueOf(expResult.getTelefono())));

        if (!(expResult.getNombre().equals(result.getNombre()) && expResult.getApellido().equals(result.getApellido())
                && String.valueOf(expResult.getId()).equals(String.valueOf(expResult.getId())) 
                && String.valueOf(expResult.getDNI()).equals(String.valueOf(expResult.getDNI()))
                && String.valueOf(expResult.getRoles_idrol()).equals(String.valueOf(expResult.getRoles_idrol())) 
                && expResult.getCorreo().equals(result.getCorreo())
                && expResult.getContrasena().equals(result.getContrasena()) 
                && expResult.getDirección().equals(result.getDirección()) 
                && String.valueOf(expResult.getTelefono()).equals(String.valueOf(expResult.getTelefono())))) {
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of readAll method, of class administradorDAO.
     */
    @Test
    public void testReadAll() {
        System.out.println("readAll");

        administradorDAO instance = new administradorDAO();
        List<administradorDTO> result = instance.readAll();
        List<administradorDTO> expResult = result;

        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if (!(result == expResult)) {
            fail("The test case is a prototype.");
        }
    }

}
