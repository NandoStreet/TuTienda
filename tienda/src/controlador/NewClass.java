/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.dao.LibroDAO;
import modelo.dao.loguinDAO;
import modelo.dto.LibroDTO;
import modelo.dto.loginDTO;
import vista.logueo;


/**
 *
 * @author David
 */
public class NewClass implements ActionListener{
    
    
    private logueo view;
    private loguinDAO model; 
    public NewClass(logueo view, loguinDAO model ){
        this.view=view;
        this.model=model;
        
        this.view.botonIniciarSesion.setActionCommand("Abrir Sesion");
        
        this.view.botonIniciarSesion.addActionListener(this);
        
    }
    public void iniciar(){
         this.view.setVisible(true);
       
    }
    public void actionPerformed(ActionEvent e){
        String comando = e.getActionCommand();
        if(comando.equals("Abrir Sesion")){
            loguinDAO login=new loguinDAO();
            loginDTO l=login.read(view.user.getText(), view.password.getText());
        //System.out.println("vista"+String.valueOf(view.user)+","+"controaldor"+String.valueOf(view.password));
            l.validar();
        }
        else{
            if(comando.equals("Abrir Sesion")){
            loguinDAO login=new loguinDAO();
            loginDTO l=login.read(view.user.getText(), view.password.getText());
            //System.out.println("vista"+String.valueOf(view.user)+","+"controaldor"+String.valueOf(view.password));
            l.validar();
            }
        }
        
        
    }
    
   /* 
    public static void main(String[] args){
        LibroDAO l= new LibroDAO();
        
        l.create(new LibroDTO("888","Yaya","Pepo"));
        l.update(new LibroDTO("888","Yaya","Pepo"));
        
        LibroDTO librobuscar=l.read("888", "888");
        System.out.println("name"+"-->"+librobuscar.getNombre());
    }
*/
    
}
