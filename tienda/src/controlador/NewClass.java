/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.dao.LibroDAO;
import modelo.dao.administradorDAO;
import modelo.dao.loguinDAO;
import modelo.dto.LibroDTO;
import modelo.dto.administradorDTO;
import modelo.dto.loginDTO;
import vista.administradorBuscar;
import vista.administradorRegistrar;
import vista.logueo;
import vista.usuarioCajero;


/**
 *
 * @author David
 */
public class NewClass implements ActionListener{
    
    
    private logueo view;
    private loguinDAO model; 
    private administradorRegistrar adm;
    private administradorBuscar admB;
    usuarioCajero caj = new usuarioCajero();
    administradorDAO a=new administradorDAO();
    public NewClass(logueo view, administradorRegistrar adm, loguinDAO model, administradorBuscar admB ){
        this.view=view;
        this.model=model;
        this.adm=adm;
        this.admB=admB;
        
        this.view.botonIniciarSesion.setActionCommand("Abrir Sesion");
        this.view.botonIniciarSesion.addActionListener(this);
        this.adm.botonRegistrarAdmin.setActionCommand("botonRegistrarAdmin");//boton "registrar" registrar usuario
        this.adm.botonRegistrarAdmin.addActionListener(this);
        this.adm.botonBuscarAdmin.setActionCommand("botonBusqueda");//boton buscar/modificar 
        this.adm.botonBuscarAdmin.addActionListener(this);
        this.admB.botonBusquedaAdministrador.setActionCommand("botonBusquedaAdministrador");//boton buscar buscar/modificar
        this.admB.botonBusquedaAdministrador.addActionListener(this);
 

    }
    public void iniciar(){
         this.view.setVisible(true);
       
    }
    @Override
    public void actionPerformed(ActionEvent e){
        String comando = e.getActionCommand();
        if(comando.equals("Abrir Sesion")){
            loguinDAO login=new loguinDAO();
            loginDTO l=login.read(view.user.getText(), view.password.getText());
        //System.out.println("vista"+String.valueOf(view.user)+","+"controaldor"+String.valueOf(view.password));
           
            
            if (!"".equals(l.getCorreo()) || !"".equals(l.getContrasena())) {

                System.out.println("primer pase");
            
            if (l.getCorreo()!= null && l.getContrasena() != null) {
                if(l.getRoles_idrol() == 1){
                    System.out.println("segundo pase");
                    adm.setVisible(true);
                    view.dispose();
                    
                    
                    //System.out.println("comando"+comando);
                    
                    //Hacer validador if - con else que tenga joptionpane 
                    
                    
                    //fin validador;
                }
                if(l.getRoles_idrol() == 2){
                    adm.setVisible(true);
                    JOptionPane.showMessageDialog(null, "Lamar a clase de logistica y ponerlo true putit4s");
                    // *******clase de logistica y ponerlo true********
                    System.out.println("rol 2");
                    view.dispose();
                    
                }
                if(l.getRoles_idrol() == 3){                   
                    caj.setVisible(true);
                    System.out.println("rol 3");
                    view.dispose();
                    
                }
            }else{
                JOptionPane.showMessageDialog(null, "Los datos son incorrectos");
            }
        }
        }
        if(comando.equals("botonRegistrarAdmin")){
            
            a.create(new administradorDTO(adm.textNombre.getText(), adm.textApellido.getText(), 
            Integer.valueOf(adm.textDNI.getText()), 1, adm.textCorreo.getText(), 
            adm.textContraseña.getText(), adm.textDireccion.getText(),
            Integer.valueOf(adm.textTelefono.getText())));
            System.out.println("rol 1");
        }
        
        if(comando.equals("botonBusqueda")){
            admB.setVisible(true);
            adm.dispose();
            
        }
            if(comando.equals("botonBusquedaAdministrador")){
            administradorDTO admDTO=a.read(Integer.valueOf(admB.barraBusquedaAdmin.getText()));
            DefaultTableModel modelo=new DefaultTableModel();
            modelo.addColumn("N°");
            modelo.addColumn("DNI");
            modelo.addColumn("NOMBRES");
            modelo.addColumn("APELLIDOS");
            modelo.addColumn("ROL");
            modelo.addColumn("ACCIONES");
            admB.tablaBusquedaAdmin.setModel(modelo);
             
            Object[] datos= new Object[6];  
            JButton b1= new JButton("+");
            datos[0]=admDTO.getId();
            datos[1]=admDTO.getDNI();
            datos[2]=admDTO.getNombre();
            datos[3]=admDTO.getApellido();
            datos[4]=admDTO.getRoles_idrol();
            datos[5]=b1;
                System.out.println("id"+admDTO.getId()+"dni"+admDTO.getDNI()+"nombre"+admDTO.getNombre()+"apell"+admDTO.getApellido()+"idrol"+admDTO.getRoles_idrol());


            modelo.addRow(datos);
                
            
            //System.out.println("vista"+String.valueOf(view.user)+","+"controaldor"+String.valueOf(view.password));
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
