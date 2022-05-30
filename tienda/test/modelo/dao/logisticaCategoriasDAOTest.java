/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import java.util.List;
import modelo.dto.logisticaCategoriasDTO;
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
public class logisticaCategoriasDAOTest {
    
    public logisticaCategoriasDAOTest() {
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
     * Test of create method, of class logisticaCategoriasDAO.
     */
    @Test
    public void testCreate() {
        System.out.println("create");
        logisticaCategoriasDTO c = null;
        logisticaCategoriasDAO instance = new logisticaCategoriasDAO();
        boolean expResult = false;
        boolean result = instance.create(c);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class logisticaCategoriasDAO.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        Object key = null;
        logisticaCategoriasDAO instance = new logisticaCategoriasDAO();
        boolean expResult = false;
        boolean result = instance.delete(key);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class logisticaCategoriasDAO.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        logisticaCategoriasDTO c = null;
        Object a = null;
        logisticaCategoriasDAO instance = new logisticaCategoriasDAO();
        boolean expResult = false;
        boolean result = instance.update(c, a);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of read method, of class logisticaCategoriasDAO.
     */
    @Test
    public void testRead_Object() {
        System.out.println("read");
        Object key = null;
        logisticaCategoriasDAO instance = new logisticaCategoriasDAO();
        logisticaCategoriasDTO expResult = null;
        logisticaCategoriasDTO result = instance.read(key);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of read method, of class logisticaCategoriasDAO.
     */
    @Test
    public void testRead_Object_Object() {
        System.out.println("read");
        Object key = null;
        Object key2 = null;
        logisticaCategoriasDAO instance = new logisticaCategoriasDAO();
        logisticaCategoriasDTO expResult = null;
        logisticaCategoriasDTO result = instance.read(key, key2);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of readAll method, of class logisticaCategoriasDAO.
     */
    @Test
    public void testReadAll() {
        System.out.println("readAll");
        logisticaCategoriasDAO instance = new logisticaCategoriasDAO();
        List<logisticaCategoriasDTO> expResult = null;
        List<logisticaCategoriasDTO> result = instance.readAll();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
