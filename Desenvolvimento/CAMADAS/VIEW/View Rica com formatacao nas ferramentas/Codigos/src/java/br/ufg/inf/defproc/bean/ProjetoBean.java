/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.inf.defproc.bean;

import br.ufg.inf.defproc.dao.ProjetoDAO;
import br.ufg.inf.defproc.model.Projeto;
import br.ufg.inf.defproc.model.Usuario;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Pedro Felipe''
 */
@ManagedBean
@ViewScoped
public class ProjetoBean implements Serializable {

    private Projeto selected;
    private List<Projeto> listaProjetos;

    public ProjetoBean() {
        init();
    }

    public List<Projeto> getListaProjetos() {
        init();
        return listaProjetos;
    }

    public Projeto getSelected() {

        return selected;
    }

    public void setSelected(Projeto selected) {
        this.selected = selected;
    }

    private void init() {
        ProjetoDAO projetoDAO = new ProjetoDAO();
        try {
            listaProjetos = projetoDAO.select();
        } catch (SQLException ex) {
            listaProjetos = null;
            System.out.println(ex.getMessage());
        }
    }

    public void insert() {
        ProjetoDAO projetoDAO = new ProjetoDAO();
        try {
            selected = projetoDAO.insert(selected);
        } catch (SQLException ex) {
            String mensagem = "Ocorreu um erro ao cadastrar o projeto!" + ex.getMessage();
            FacesMessage message = new FacesMessage(mensagem);
            FacesContext.getCurrentInstance().addMessage("mensagem", message);
        }
    }

    public void preparaNovo() {
        selected = new Projeto();
    }

    public void desativaProjeto(Projeto projeto) {
        projeto.setAtivo(false);
        ProjetoDAO projetoDAO = new ProjetoDAO();
        try {
            projetoDAO.updateAtivo(projeto);
            String mensagem = "Status atualizado!";
            FacesMessage message = new FacesMessage(mensagem);
            FacesContext.getCurrentInstance().addMessage("mensagem", message);
        } catch (SQLException ex) {
            String mensagem = "Ocorreu um erro ao atualizar o status do projeto!" + ex.getMessage();
            FacesMessage message = new FacesMessage(mensagem);
            FacesContext.getCurrentInstance().addMessage("mensagem", message);
        }
    }

    public void ativaProjeto(Projeto projeto) {
        projeto.setAtivo(true);
        ProjetoDAO projetoDAO = new ProjetoDAO();
        try {
            projetoDAO.updateAtivo(projeto);
            String mensagem = "Status atualizado!";
            FacesMessage message = new FacesMessage(mensagem);
            FacesContext.getCurrentInstance().addMessage("mensagem", message);
        } catch (SQLException ex) {
            String mensagem = "Ocorreu um erro ao atualizar o status do projeto!" + ex.getMessage();
            FacesMessage message = new FacesMessage(mensagem);
            FacesContext.getCurrentInstance().addMessage("mensagem", message);
        }
    }

    public void insertGerente(Usuario usuario) {
        ProjetoDAO projetoDAO = new ProjetoDAO();
        try {
            projetoDAO.insertGerente(selected, usuario);
        } catch (SQLException ex) {
            String mensagem = "Ocorreu um erro ao inserir um gerente!" + ex.getMessage();
            FacesMessage message = new FacesMessage(mensagem);
            FacesContext.getCurrentInstance().addMessage("mensagem", message);
        }

    }

    public void insertParticipante(Usuario usuario) {
        ProjetoDAO projetoDAO = new ProjetoDAO();
        try {
            projetoDAO.insertParticipante(selected, usuario);
        } catch (SQLException ex) {
            String mensagem = "Ocorreu um erro ao inserir um participante!" + ex.getMessage();
            FacesMessage message = new FacesMessage(mensagem);
            FacesContext.getCurrentInstance().addMessage("mensagem", message);
        }
    }

    public void insertAprovador(Usuario usuario) {
        ProjetoDAO projetoDAO = new ProjetoDAO();
        try {
            projetoDAO.insertAprovador(selected, usuario);
        } catch (SQLException ex) {
            String mensagem = "Ocorreu um erro ao inserir um aprovador!" + ex.getMessage();
            FacesMessage message = new FacesMessage(mensagem);
            FacesContext.getCurrentInstance().addMessage("mensagem", message);
        }
    }

    public void insertObservador(Usuario usuario) {
        ProjetoDAO projetoDAO = new ProjetoDAO();
        try {
            projetoDAO.insertObservador(selected, usuario);
        } catch (SQLException ex) {
            String mensagem = "Ocorreu um erro ao inserir um observador!" + ex.getMessage();
            FacesMessage message = new FacesMessage(mensagem);
            FacesContext.getCurrentInstance().addMessage("mensagem", message);
        }
    }
}
