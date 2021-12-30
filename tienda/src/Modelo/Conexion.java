/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author MOISES
 */
public class Conexion {
    Connection con;
    public Connection getConnection(){
        try {
            String url = "jdbc:mysql://localhost:3300/de_compras_store";
            String username = "root";
            String password = "1234"; 
            
            con = DriverManager.getConnection(url, username, password);
            return con;
        } catch (SQLException e) {
            System.out.println(e.toString());
            JOptionPane.showMessageDialog(null, "No se pudo conectar a la base de datos");
        }
        return null;
    }
}
