/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.app.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "usuariorol")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuariorol.findAll", query = "SELECT u FROM Usuariorol u")})
public class Usuariorol implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idusuariorol")
    private Integer idusuariorol;
    @JoinColumn(name = "idrol", referencedColumnName = "idrol")
    @ManyToOne(fetch = FetchType.EAGER)
    private Rol idrol;
    @JoinColumn(name = "idusuario", referencedColumnName = "idusuario")
    @ManyToOne(fetch = FetchType.EAGER)
    private Usuario idusuario;

    public Usuariorol() {
    }

    public Usuariorol(Integer idusuariorol) {
        this.idusuariorol = idusuariorol;
    }

    public Integer getIdusuariorol() {
        return idusuariorol;
    }

    public void setIdusuariorol(Integer idusuariorol) {
        this.idusuariorol = idusuariorol;
    }

    public Rol getIdrol() {
        return idrol;
    }

    public void setIdrol(Rol idrol) {
        this.idrol = idrol;
    }

    public Usuario getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Usuario idusuario) {
        this.idusuario = idusuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idusuariorol != null ? idusuariorol.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuariorol)) {
            return false;
        }
        Usuariorol other = (Usuariorol) object;
        if ((this.idusuariorol == null && other.idusuariorol != null) || (this.idusuariorol != null && !this.idusuariorol.equals(other.idusuariorol))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.app.entity.Usuariorol[ idusuariorol=" + idusuariorol + " ]";
    }
    
}
