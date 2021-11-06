/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author MOISES
 */
public class LoginDAO {
    Connection connection;
    PreparedStatement statement;
    ResultSet resulset;
    Conexion conexion = new Conexion();

    public Login log(String correo, String contrasena){
        Login login = new Login();
        String sql = "SELECT * FROM administrador,logistica,vendedor WHERE correo = ? AND contrasena = ?";  //a que tabla se referencia
        try {
            connection = conexion.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setString(1, correo);    //el indice de la tabla y correo
            statement.setString(2, contrasena);    //el indice de la tabla y contrasena
            resulset = statement.executeQuery();
            if (resulset.next()) {
                //login.setId(resulset.getInt("id")); //id diferente para cada usuario :/
                login.setCorreo(resulset.getString("correo"));
                login.setContrasena(resulset.getString("contrasena"));                
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return login;
    }
    
    
}
