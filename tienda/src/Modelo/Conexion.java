/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author MOISES
 */
public class Conexion {
    Connection connection;
    public Connection getConnection(){
        try {
            String url = "jdbc:mysql://localhost:3306/tienda";
            String username = "root";
            String password = "";
            
            connection = DriverManager.getConnection(url, username, password);
            return connection;
        } catch (SQLException e) {
            System.out.println(e.toString());
            
        }
        return null;
    }
}
