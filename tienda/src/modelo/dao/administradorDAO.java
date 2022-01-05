/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.conexion.Conexion;
import modelo.dto.LibroDTO;
import modelo.dto.administradorDTO;
import modelo.interfaces.crud;

/**
 *
 * @author David
 */
public class administradorDAO implements crud<administradorDTO> {
    
    private static final String SQL_Insert="INSERT into usuarios(nombre, apellido, dni, rolesIdrol, correo, contrasena, direccion, telefono, estado) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SQL_Delete="DELETE from libros WHERE isbn=?";
    private static final String SQL_Update="UPDATE libros SET nombres=?, autor=? WHERE isbn=?";
    private static final String SQL_Read="SELECT * FROM usuarios WHERE dni = ?";
    private static final String SQL_ReadAll="SELECT * from libros";
    private static final Conexion con=Conexion.saberEstado();//singleton

    @Override
    public boolean create(administradorDTO c) {
        PreparedStatement ps;
        try {
            
            ps=con.getCon().prepareStatement(SQL_Insert);
            ps.setString(1, c.getNombre());
            ps.setString(2, c.getApellido());
            ps.setInt(3, c.getDNI());
            ps.setInt(4, c.getRoles_idrol());
            ps.setString(5, c.getCorreo());
            ps.setString(6, c.getContrasena());
            ps.setString(7, c.getDirección());
            ps.setInt(8, c.getTelefono());
            ps.setInt(9, 1);
            
            if(ps.executeUpdate()>0){
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(LibroDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{//Es una clausula que se va a ejecutar siempre
            con.cerrarConexion();

        }
        return false;
    }

    @Override
    public boolean delete(Object key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(administradorDTO c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public administradorDTO read(Object key) {
        PreparedStatement ps;
        ResultSet res;
        administradorDTO l = null;
        try {
            
            ps=con.getCon().prepareStatement(SQL_Read);
            ps.setInt(1, (int) key);
            res=ps.executeQuery();
            while(res.next()){
                
                l=new administradorDTO(res.getInt("id"),res.getString("nombre"),res.getString("apellido"),
                        res.getInt("dni"), res.getInt("rolesIdrol"),   res.getString("correo") , 
                        res.getString("contrasena"),  res.getString("direccion"),  res.getInt("telefono"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(LibroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{//Es una clausula que se va a ejecutar siempre
            con.cerrarConexion();

        }
        System.out.println(key+"XDDDD");
        return l;
    }

    @Override
    public administradorDTO read(Object key, Object key2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<administradorDTO> readAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


   
    
}
