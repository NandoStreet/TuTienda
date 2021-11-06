/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author David Pablo
 */
public class metodoLoguin {
    transient ResultSet rs;
    transient Statement st;
    transient Basedatos bd = new Basedatos ();
    
    public int validarIngreso(){
        int resultado=0;
        try {
            bd.conectar();
            st = bd.con.createStatement();
            String usuario=logueo.user.getText();
            String contraseña=String.valueOf(logueo.password.getPassword());
            
            String sql_admin=String.format("select * from administrador where correo = binary'%s' and contrasena = binary'%s';", usuario,contraseña);
            System.out.println(sql_admin);
            rs = st.executeQuery(sql_admin);
            if(rs.next()){
                resultado=1;
            }
        } catch (SQLException ex) {
            Logger.getLogger(metodoLoguin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }
}
