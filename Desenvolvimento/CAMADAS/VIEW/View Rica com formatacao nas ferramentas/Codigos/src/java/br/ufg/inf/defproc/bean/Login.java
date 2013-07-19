/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.inf.defproc.bean;

import br.ufg.inf.defproc.dao.UsuarioDAO;
import br.ufg.inf.defproc.model.Usuario;
import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Pedro Felipe''
 */
@ManagedBean
@SessionScoped
public class Login implements Serializable {

    private Usuario usuario;
    private int tentativas = 0;

    public Login() {
        usuario = new Usuario();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void login() {
        //se o usuário tiver tentado logar-se por mais de uma vez, o sistema irá dormir como medida de segurança por alguns segundos;
        if (tentativas > 1) {
            try {
                Thread.sleep(tentativas * 2500);
            } catch (InterruptedException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario usuarioBD = null;
        try {
            usuarioBD = usuarioDAO.select(usuario.getEmail());
            if (usuarioBD == null) {
                tentativas++;
                String mensagem = "Usuário e/ou senha incorretos!";
                FacesMessage message = new FacesMessage(mensagem);
                FacesContext.getCurrentInstance().addMessage("mensagem", message);

            } else if (usuarioBD.getPassword().equals(usuario.getPassword())) {
                tentativas = 0;
                session.setMaxInactiveInterval(600);
                session.setAttribute("usuario", usuario);

                System.out.println(usuarioBD.getNome() + " efetuou login no sistema");
                try {
                    if (usuarioBD.isAdmin()) {
                        FacesContext.getCurrentInstance().getExternalContext().redirect("/Defproc/paginas/index_admin.xhtml");
                    } else {
                        FacesContext.getCurrentInstance().getExternalContext().redirect("/Defproc/paginas/index.xhtml");
                    }
                } catch (IOException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }


            } else {
                tentativas++;
                String mensagem = "Usuário e/ou senha incorretos!";
                FacesMessage message = new FacesMessage(mensagem);
                FacesContext.getCurrentInstance().addMessage("mensagem", message);


            }
        } catch (SQLException ex) {
            String mensagem = "Ocorreu um erro ao acessar o banco de dados!" + ex.getMessage();
            FacesMessage message = new FacesMessage(mensagem);
            FacesContext.getCurrentInstance().addMessage("mensagem", message);

        }





    }

    public void logout() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        session.invalidate();
    }
}
