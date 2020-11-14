/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.app.controlador;

import edu.app.entity.Usuario;
import edu.app.facade.UsuarioFacadeLocal;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import org.primefaces.PrimeFaces;

/**
 *
 * @author Usuario
 */
@Named(value = "registroRequest")
@RequestScoped
public class RegistroRequest implements Serializable{
    @EJB
    UsuarioFacadeLocal usuarioFacadeLocal;
    
    
        
    private Usuario usuReg = new Usuario();
    
    /**
     * Creates a new instance of RegistroRequest
     */
    public RegistroRequest() {
    }
    
    public void registrarUsuario(){
        String mensaje ="";
        try {
             usuarioFacadeLocal.create(usuReg);
             mensaje = "swal('Usuario registrado !!!!', 'Correctamente', 'success');";
             usuReg = new Usuario();
        } catch (Exception e) {
            System.out.println("error creando un usuario RegistroRequest:registrarUsuario " + e.getMessage());
             mensaje = "swal('Error registrado !!!!', 'Usuario', 'error');";
        }
      
        PrimeFaces.current().executeScript(mensaje);
    } 

    public Usuario getUsuReg() {
        return usuReg;
    }

    public void setUsuReg(Usuario usuReg) {
        this.usuReg = usuReg;
    }
    
}
