/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.dao.loguinDAO;
import vista.logueo;

/**
 *
 * @author David
 */
public class MVC {
    public static void main(String[] args){
        logueo lg=new logueo();  
        loguinDAO lDAO= new loguinDAO();
        NewClass nc=new NewClass(lg, lDAO);
        nc.iniciar();
        
    }
}
