/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.app.facade;

import edu.app.entity.Usuariorol;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Usuario
 */
@Stateless
public class UsuariorolFacade extends AbstractFacade<Usuariorol> implements UsuariorolFacadeLocal {

    @PersistenceContext(unitName = "1966820-AppV7PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuariorolFacade() {
        super(Usuariorol.class);
    }
    
  
    
    
    
    
    
    
    
}
