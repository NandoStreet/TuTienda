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
import modelo.interfaces.Obligacion;

/**
 *
 * @author David
 */
public class LibroDAO implements Obligacion<LibroDTO> {
    
    private static final String SQL_Insert="INSERT into libros(isbn, nobmre ,autor) VALUES (?, ?, ?)";
    private static final String SQL_Delete="DELETE from libros WHERE isbn=?";
    private static final String SQL_Update="UPDATE libros SET nombres=?, autor=? WHERE isbn=?";
    private static final String SQL_Read="SELECT * from libros WHERE isbn =?";
    private static final String SQL_ReadAll="SELECT * from libros";
    private static final Conexion con=Conexion.saberEstado();//singleton

    @Override
    public boolean create(LibroDTO c) {
        PreparedStatement ps;
        try {
            
            ps=con.getCon().prepareStatement(SQL_Insert);
            ps.setString(1, c.getIsbn());
            ps.setString(2, c.getNombre());
            ps.setString(3, c.getAutor());
            
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
        try {
            PreparedStatement ps;
            ps=con.getCon().prepareStatement(SQL_Delete);
            ps.setString(1, key.toString());
            if(ps.executeUpdate()>0){
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(LibroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{//Es una clausula que se va a ejecutar siempre
            con.cerrarConexion();

        }
        return false;
        
    }

    @Override
    public boolean update(LibroDTO c) {
        try {
            PreparedStatement ps;
            ps=con.getCon().prepareStatement(SQL_Update);
            ps.setString(1, c.getNombre());
            ps.setString(2, c.getAutor());
            ps.setString(3, c.getIsbn());
            if(ps.executeUpdate()>0){
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(LibroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{//Es una clausula que se va a ejecutar siempre
            con.cerrarConexion();

        }
        return false;
    }
    //de aqui en adelante estos metodo son distintos
    @Override
    public LibroDTO read(Object key) {
        PreparedStatement ps;
        ResultSet res;
        LibroDTO l = null;
        try {
            
            ps=con.getCon().prepareStatement(SQL_Read);
            ps.setString(1, key.toString());
            res=ps.executeQuery();
            while(res.next()){
                l=new LibroDTO(res.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(LibroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{//Es una clausula que se va a ejecutar siempre
            con.cerrarConexion();

        }
        return l;
    }

    @Override
    public List<LibroDTO> readAll() {
         PreparedStatement ps;
         ResultSet res;
         ArrayList<LibroDTO> libros=new ArrayList();
        try {

            
            ps=con.getCon().prepareStatement(SQL_ReadAll);
            res=ps.executeQuery();
            while(res.next()){
                libros.add(new LibroDTO(res.getString(1), res.getString(2), res.getString(3)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(LibroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{//Es una clausula que se va a ejecutar siempre
            con.cerrarConexion();

        }
        return libros;
   
    }

    @Override
    public LibroDTO read(Object key, Object key2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
