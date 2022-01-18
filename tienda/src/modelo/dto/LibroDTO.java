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
public class LibroDTO {
    private String isbn;
    private String nombre;
    private String autor;
   
    public LibroDTO(){
        
    }

    public LibroDTO(String isbn) {
        this.isbn = isbn;
    }

    public LibroDTO(String isbn, String nombre, String autor) {
        this.isbn = isbn;
        this.nombre = nombre;
        this.autor = autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getNombre() {
        return nombre;
    }

    public String getAutor() {
        return autor;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
    
}
