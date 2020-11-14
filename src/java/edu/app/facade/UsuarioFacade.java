/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.app.facade;

import edu.app.entity.Usuario;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Usuario
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> implements UsuarioFacadeLocal {

    @PersistenceContext(unitName = "1966820-AppV7PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    } 
    
    
    public Usuario loginUsuario(String correo, String clave){
        try {
            Query qt = em.createQuery("SELECT u FROM Usuario u WHERE u.correo = :correo AND u.clave=:clave");
            qt.setParameter("correo", correo);
            qt.setParameter("clave", clave);
            return (Usuario) qt.getSingleResult();
            
        } catch (Exception e) {
        return  new Usuario();
        }
    
    }

    
}
