/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.inf.defproc.bean;

import br.ufg.inf.defproc.dao.UsuarioDAO;
import br.ufg.inf.defproc.model.Usuario;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author pedro.teles
 */
@ManagedBean
@ViewScoped
public class UsuarioBean implements Serializable{
    
    private List<Usuario> listaUsuarios;
    
    private Usuario selected;
    
    public UsuarioBean(){
        init();
    }
    
    public void init(){
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        try {
            listaUsuarios = usuarioDAO.select();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void preparaNovo(){
        selected = new Usuario();
    }

    public List<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public Usuario getSelected() {
        return selected;
    }

    public void setSelected(Usuario selected) {
        this.selected = selected;
    }
    
    
    
}
