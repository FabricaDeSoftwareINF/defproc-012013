/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.inf.defproc.bean;

import br.ufg.inf.defproc.model.Usuario;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Pedro Felipe''
 */
@ManagedBean
@SessionScoped
public class Login implements Serializable {

    private Usuario usuario;

    public Login() {
        usuario = new Usuario();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String login() {
        if (usuario.getLogin().equals(usuario.getPassword())&&!usuario.getLogin().equals("")) {
            return "index.xhtml";
        } else {
            FacesMessage message = new FacesMessage("Usuário ou senha incorretos!");    
            FacesContext.getCurrentInstance().addMessage("mensagem", message);
            return "login.xhtml";
        }
    }
}
