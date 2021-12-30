/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.conexion.Conexion;
import modelo.dto.LibroDTO;
import modelo.dto.loginDTO;
import modelo.interfaces.Obligacion;

/**
 *
 * @author David
 */
public class loguinDAO implements Obligacion<loginDTO> {
    
    private static final String SQL_Insert="INSERT into libros(isbn, nobmre ,autor) VALUES (?, ?, ?)";
    private static final String SQL_Delete="DELETE from libros WHERE isbn=?";
    private static final String SQL_Update="UPDATE libros SET nombres=?, autor=? WHERE isbn=?";
    private static final String SQL_Read="SELECT * FROM usuarios WHERE correo = ? AND contrasena = ?";
    private static final String SQL_ReadAll="SELECT * from libros";
    private static final Conexion con=Conexion.saberEstado();//singleton

    @Override
    public boolean create(loginDTO c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Object key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(loginDTO c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public loginDTO read(Object key, Object key2) {
         PreparedStatement ps;
        ResultSet res;
        loginDTO l = null;
        try {
            
            ps=con.getCon().prepareStatement(SQL_Read);
            ps.setString(1, key.toString());
            ps.setString(2, key2.toString());
            res=ps.executeQuery();
            while(res.next()){
                l=new loginDTO(res.getInt("id"), res.getString(1), res.getString(2) , res.getInt("roles_idrol"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(LibroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{//Es una clausula que se va a ejecutar siempre
            con.cerrarConexion();

        }
        return l;
    }

    @Override
    public List<loginDTO> readAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public loginDTO read(Object key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    
}
