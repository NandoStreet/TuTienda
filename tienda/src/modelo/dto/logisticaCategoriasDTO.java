/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dto;
/**
 *
 * @author David
 */
public class logisticaCategoriasDTO {//NOSONAR
    private String codigo;
    private String nombre;
    private String descripcion;


    public logisticaCategoriasDTO(String codigo, String nombre, String descripcion) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
    
    }

    public logisticaCategoriasDTO(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    
    
    public String getNombre() {
        return nombre;
    }

   

    public String getDescripcion() {
        return descripcion;
    }

    

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

  

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

   
 
}
