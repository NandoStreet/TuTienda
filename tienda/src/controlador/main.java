/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.dao.loguinDAO;
import vista.administradorBuscar;
import vista.administradorRegistrar;
import vista.logueo;

/**
 *
 * @author David
 */
public class main {
    public static void main(String[] args){
        logueo lg=new logueo();  
        loguinDAO lDAO= new loguinDAO();
        administradorRegistrar adm = new administradorRegistrar();
        administradorBuscar admB= new administradorBuscar(); 
        NewClass nc=new NewClass(lg,adm, lDAO, admB);
        nc.iniciar();
        
    }
}
