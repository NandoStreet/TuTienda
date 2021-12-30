
package vista;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Basedatos {
    static final String ROOT= "root";
    static final String URL = "jdbc:mysql://localhost:3306/de_compras_store?useSSL=false";
    
    Connection con;
    Statement st;
    ResultSet rs;
    
    public Basedatos (){
        //constructor vacio
    }

    public Connection conectar(){
        try{
            con = DriverManager.getConnection(URL,ROOT,"1234");
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "No se pudo conectar a la base de datos");
        }
        return con;
    }
}