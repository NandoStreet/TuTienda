/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import modelo.dto.logisticaProveedorDTO;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import vista.CajeroVistas.cajeroRegistrarCotizacion;
import vista.CajeroVistas.cajeroRegistrarVenta;
import vista.CajeroVistas.usuarioCajero;
import vista.LogisticaVistas.logisticaCategoriasProd;
import vista.LogisticaVistas.logisticaModificarProd;
import vista.LogisticaVistas.logisticaModificarProv;
import vista.LogisticaVistas.logisticaRegistrarProd;
import vista.LogisticaVistas.logisticaRegistroProv;
import vista.administradorBuscar;
import vista.administradorModificar;
import vista.administradorPagoModificar;
import vista.administradorPagoRegistrar;
import vista.administradorRegistrar;
import vista.administradorSubPagoModificar;
import vista.administradordetallesPagoModificar;
import vista.logueo;

/**
 *
 * @author David
 */
public class logisticaProveedorDAOTest {
    
    public logisticaProveedorDAOTest() {
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
     * Test of create method, of class logisticaProveedorDAO.
     */
    @Test
    public void testCreate() {
        //Variable global
        boolean expResult=true;
        boolean result=false;
        
        logueo lg=new logueo();  
        loguinDAO lDAO= new loguinDAO();
        administradorDAO a=new administradorDAO();
        administradorPagoDAO a1=new administradorPagoDAO();
        logisticaProveedorDAO lp=new logisticaProveedorDAO();
        logisticaProductosDAO lproductos=new logisticaProductosDAO();
        logisticaCategoriasDAO lcategorias= new logisticaCategoriasDAO();
        CajeroVentasDAO cajv= new CajeroVentasDAO();
        administradorRegistrar adm = new administradorRegistrar();
        administradorBuscar admB= new administradorBuscar(); 
        administradorModificar admM=new administradorModificar();
        administradorPagoRegistrar admPR=new administradorPagoRegistrar();
        administradorPagoModificar admPM=new administradorPagoModificar();
        administradordetallesPagoModificar adPM=new administradordetallesPagoModificar();
        administradorSubPagoModificar adSPM=new administradorSubPagoModificar();
        logisticaRegistrarProd lrprod= new logisticaRegistrarProd();
        logisticaModificarProd lmproducto= new logisticaModificarProd();
        
        //Logisitica
        logisticaRegistroProv lrp=new logisticaRegistroProv();
        logisticaModificarProv lmp=new logisticaModificarProv();
        logisticaCategoriasProd lcp=new logisticaCategoriasProd();
         //Cajero
         
         cajeroRegistrarCotizacion cajRegC=new cajeroRegistrarCotizacion();
         cajeroRegistrarVenta cajRegV= new cajeroRegistrarVenta();
         usuarioCajero cajU=new usuarioCajero();
        
        /*Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
            Matcher mather = pattern.matcher(lrp.textEmail.getText());*/
             int caso = 0;
            //cargar el formulario 
            lrp.textRazonSocial.setText("s");
            lrp.textRepresentante.setText("sdssdsd");
            lrp.textTelefono.setText("987330113");
            lrp.textDistrito.setText("sdssdsdsd");
            lrp.textRUC.setText("95486245789");
            lrp.comboBoxEstadoCivil.setSelectedItem("Activo");
            lrp.textEmail.setText("dadsadas@hotmail.com");
            lrp.textDireccion.setText("sdssdsdsdsdsd");
            lrp.textAreaDescripcion.setText("sdssdsdsdsdsdsd");
            
            if (lrp.textRazonSocial.getText().isEmpty() || lrp.textRepresentante.getText().isEmpty() || lrp.textTelefono.getText().isEmpty() || lrp.textDistrito.getText().isEmpty() || lrp.textRUC.getText().isEmpty()|| lrp.comboBoxEstadoCivil.getSelectedItem()=="Ninguno" || lrp.textEmail.getText().isEmpty() || lrp.textDireccion.getText().isEmpty() || lrp.textAreaDescripcion.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Existe por lo menos algun campo vacío");
            } else {
                

               

                if (lrp.textRazonSocial.getText().length() <= 3) {
                    caso = 1;
                }
                if (lrp.textRepresentante.getText().length() <= 3) {
                    caso = 2;
                }
                if (lrp.textTelefono.getText().length() !=9) {
                    caso = 3;
                }
                if (lrp.textDistrito.getText().length() <= 2) {
                    caso = 4;
                }
                if (lrp.textRUC.getText().length() !=11) {
                    caso = 5;
                }
                if (lrp.textDireccion.getText().length() <= 3) {
                    caso = 6;
                }
                if (lrp.textAreaDescripcion.getText().length() <= 3) {
                    caso = 7;
                }
                
                if (lrp.comboBoxEstadoCivil.getSelectedItem()=="Ninguno") {
                    caso = 8;
                }
                if (lrp.textEmail.getText().length() <= 3 ) {
                    
               
                    caso = 9;
                }
                //long numberOFDays = DAYS.(LocalDate.parse(myDate),  LocalDate.now());

                switch (caso) {
                    case 0:
                        result=lp.create(new logisticaProveedorDTO(lrp.textRazonSocial.getText(), lrp.textRepresentante.getText(), Integer.valueOf(lrp.textTelefono.getText()), lrp.textDistrito.getText(), lrp.textRUC.getText(), String.valueOf(lrp.comboBoxEstadoCivil.getSelectedItem()), lrp.textEmail.getText(), lrp.textDireccion.getText(), lrp.textAreaDescripcion.getText()));
                        System.out.println("-->"+result);
                        expResult = true;
                        assertEquals(expResult, result);   
                        if (!result){
                            fail("The test case is a prototype.");
                        }
                        
                        
                        
                        JOptionPane.showMessageDialog(null, "Proveedor Registrado Correctamente.");break;
                    case 1:
                        System.out.println("La razon social debe tener mas de 3 caracteres.");
                        result=false;
                        assertEquals(expResult, result); 
                        break;
                    case 2:
                        JOptionPane.showMessageDialog(null, "El representante debe tener mas de 3 caracteres.");
                        break;
                    case 3:
                        JOptionPane.showMessageDialog(null, "El teléfono debe ser de 9 dígitos.");
                        break;
                    case 4:
                        JOptionPane.showMessageDialog(null, "El distrito debe tener mas de 2 caracteres.");
                        break;
                    case 5:
                        JOptionPane.showMessageDialog(null, "El RUC debe contener 11 digitos.");
                        break;
                    case 6:
                        JOptionPane.showMessageDialog(null, "La dirección debe contener mas de 3 caracteres.");
                        break;
                    case 7:
                        JOptionPane.showMessageDialog(null, "La descripción debe contener mas de 3 caracteres.");
                        break;
                    case 8:
                        JOptionPane.showMessageDialog(null, "Estado civil no seleccionado");
                        break;
                    case 9:
                        JOptionPane.showMessageDialog(null, "El email es invalido o debe contener mas de 3 caracteres.");
                    break;
                }

            }   
        
        
     
    }

    
}
