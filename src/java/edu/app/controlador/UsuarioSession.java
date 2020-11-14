/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.app.controlador;

import edu.app.entity.Usuario;
import edu.app.facade.UsuarioFacadeLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;
import org.primefaces.PrimeFaces;

/**
 *
 * @author Usuario
 */
@Named(value = "usuarioSession")
@SessionScoped
public class UsuarioSession implements Serializable {

    @EJB
    UsuarioFacadeLocal usuarioFacadeLocal;

    private String correo;
    private String clave;
    private Usuario usuLogin = new Usuario();

    /**
     * Creates a new instance of UsuarioSession
     */
    public UsuarioSession() {
    }

    public void validarUsuario() {
        String mensaje = "";
        try {
            usuLogin = usuarioFacadeLocal.loginUsuario(correo, clave);
            if (usuLogin.getIdusuario() == null) {
                mensaje = "swal('Usuario NO registrado !!!!', 'En el sistema', 'error');";
            } else {
                mensaje = "swal('Usuario encontrado  !!!!', 'Correctamente', 'success');";
            }

        } catch (Exception e) {
            mensaje = "swal('Usuario NO registrado !!!!', 'En el sistema', 'error');";
        }
        PrimeFaces.current().executeScript(mensaje);

    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Usuario getUsuLogin() {
        return usuLogin;
    }

    public void setUsuLogin(Usuario usuLogin) {
        this.usuLogin = usuLogin;
    }

}
