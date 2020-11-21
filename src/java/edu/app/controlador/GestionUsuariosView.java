/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.app.controlador;

import edu.app.entity.Usuario;
import edu.app.facade.UsuarioFacadeLocal;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

import org.primefaces.PrimeFaces;

/**
 *
 * @author Usuario
 */
@Named(value = "gestionUsuariosView")
@ViewScoped
public class GestionUsuariosView implements Serializable {

    @EJB
    UsuarioFacadeLocal usuarioFacadeLocal;
    @Inject
    UsuarioSession usuarioSession;
    
    private Usuario usuEditar = new Usuario();
    private Usuario usuNuevo = new Usuario();

    private ArrayList<Usuario> listaUsuarios = new ArrayList<>();

    @PostConstruct
    public void cargaListaUsuarios() {
        listaUsuarios.addAll(usuarioFacadeLocal.findAll());
    }

    public void cargaEditarUsuario(Usuario usuRemov) {
        usuEditar = usuRemov;
    }

    public void editarUsuario() {
        String mensaje = "";
        try {
            usuarioFacadeLocal.edit(usuEditar);
            mensaje = "swal('Usuario actualizado !!!!', 'Correctamente', 'success');";
        } catch (Exception e) {
            System.out.println("edu.app.controlador.GestionUsuariosView.editarUsuario() " + e.getMessage());
            mensaje = "swal('Error actualizando !!!!', 'Usuario', 'error');";
        }

        PrimeFaces.current().executeScript(mensaje);
    }

    public void eliminarUsuario(Usuario usuRemov) {
        String mensaje = "";
        try {
            usuarioFacadeLocal.remove(usuRemov);
            listaUsuarios.remove(usuRemov);
            mensaje = "swal('Usuario removido !!!!', 'Correctamente', 'success');";
        } catch (Exception e) {
            System.out.println("edu.app.controlador.GestionUsuariosView.eliminarUsuario() " + e.getMessage());
            mensaje = "swal('Error removiendo !!!!', 'Usuario', 'error');";
        }

        PrimeFaces.current().executeScript(mensaje);
    }

    public void registrarUsuario() {
        String mensaje = "";
        try {
            usuarioFacadeLocal.create(usuNuevo);
            listaUsuarios.add(usuNuevo);
            mensaje = "swal('Usuario registrado !!!!', 'Correctamente', 'success');";
            usuNuevo = new Usuario();
        } catch (Exception e) {
            System.out.println("error creando un usuario RegistroRequest:registrarUsuario " + e.getMessage());
            mensaje = "swal('Error registrado !!!!', 'Usuario', 'error');";
        }

        PrimeFaces.current().executeScript(mensaje);
    }

    public void descargaReporte() throws SQLException {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ExternalContext context = facesContext.getExternalContext();
        HttpServletRequest request = (HttpServletRequest) context.getRequest();
        HttpServletResponse response = (HttpServletResponse) context.getResponse();
        response.setContentType("application/pdf");

        try {
            Map parametro = new HashMap();
            parametro.put("ficha", "1966820/21/26/37");
            parametro.put("usuarioReporte", usuarioSession.getUsuLogin().getNombres() + " " +usuarioSession.getUsuLogin().getApellidos() );
            parametro.put("rutaImagen", context.getRealPath("src/images/Encabezado.png"));
            Connection conec = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/veterinaria", "root", "root");
            File jasper = new File(context.getRealPath("/WEB-INF/classes/edu/app/reportes/ReporteUsuarios.jasper"));

            JasperPrint jp = JasperFillManager.fillReport(jasper.getPath(), parametro, conec);

            HttpServletResponse hsr = (HttpServletResponse) context.getResponse();
            hsr.addHeader("Content-disposition", "attachment; filename=Lista Usuarios.pdf");
            OutputStream os = hsr.getOutputStream();
            JasperExportManager.exportReportToPdfStream(jp, os);
            os.flush();
            os.close();
            facesContext.responseComplete();

        } catch (JRException e) {
            System.out.println("edu.app.controlador.GestionUsuariosView.descargaReporte() " + e.getMessage());
        } catch (IOException i) {
            System.out.println("edu.app.controlador.GestionUsuariosView.descargaReporte() " + i.getMessage());
        } catch (SQLException q) {
            System.out.println("edu.app.controlador.GestionUsuariosView.descargaReporte() " + q.getMessage());
        }

    }

    /**
     * Creates a new instance of GestionUsuariosView
     */
    public GestionUsuariosView() {
    }

    public ArrayList<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(ArrayList<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public Usuario getUsuEditar() {
        return usuEditar;
    }

    public void setUsuEditar(Usuario usuEditar) {
        this.usuEditar = usuEditar;
    }

    public Usuario getUsuNuevo() {
        return usuNuevo;
    }

    public void setUsuNuevo(Usuario usuNuevo) {
        this.usuNuevo = usuNuevo;
    }

}
