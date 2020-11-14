/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.app.facade;

import edu.app.entity.Usuario;
import edu.app.entity.Usuariorol;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Usuario
 */
@Local
public interface UsuariorolFacadeLocal {

    void create(Usuariorol usuariorol);

    void edit(Usuariorol usuariorol);

    void remove(Usuariorol usuariorol);

    Usuariorol find(Object id);

    List<Usuariorol> findAll();

    List<Usuariorol> findRange(int[] range);

    int count();

    
}
