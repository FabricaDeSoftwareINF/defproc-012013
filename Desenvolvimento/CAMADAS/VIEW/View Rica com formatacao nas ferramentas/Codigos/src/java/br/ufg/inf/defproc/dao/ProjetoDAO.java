/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.inf.defproc.dao;

import br.ufg.inf.defproc.factory.ConexaoBd;
import br.ufg.inf.defproc.model.Projeto;
import br.ufg.inf.defproc.model.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Pedro Felipe''
 */
public class ProjetoDAO {
    
    public Projeto insert(Projeto projeto) throws SQLException{
        PreparedStatement sql = ConexaoBd.getInstance().prepareStatement("INSERT INTO projeto (nome, descricao, ativo) VALUES (?, ?,?)", Statement.RETURN_GENERATED_KEYS);
        sql.setString(1, projeto.getNome());
        sql.setString(2, projeto.getDescricao());   
        sql.setBoolean(3, true);
        sql.execute();
        ResultSet rs = sql.getGeneratedKeys();
        if(rs.next()){
            projeto.setId(rs.getInt(1));
        }
        return projeto;
        
    }
    
    public void updateAtivo(Projeto projeto) throws SQLException{
        PreparedStatement sql = ConexaoBd.getInstance().prepareStatement("UPDATE projeto SET ativo = ? WHERE id_projeto = ?");
        sql.setBoolean(1, projeto.isAtivo());
        sql.setInt(2, projeto.getId());
        sql.execute();
        
    }
    
    public List<Projeto> select() throws SQLException{
        PreparedStatement sql = ConexaoBd.getInstance().prepareStatement("SELECT id_projeto, nome, descricao, ativo FROM projeto order by id_projeto");
        ResultSet rs = sql.executeQuery();
        List<Projeto> listaProcessos = new ArrayList<Projeto>();
        while(rs.next()){
            Projeto projeto = new Projeto();
            projeto.setId(rs.getInt("id_projeto"));
            projeto.setNome(rs.getString("nome"));
            projeto.setDescricao(rs.getString("descricao"));
            projeto.setAtivo(rs.getBoolean("ativo"));
            projeto.setAprovadores(selectAprovadores(projeto.getId()));
            projeto.setGerentes(selectGerentes(projeto.getId()));
            projeto.setObservadores(selectObservadores(projeto.getId()));
            projeto.setParticipantes(selectParticipantes(projeto.getId()));
            listaProcessos.add(projeto);
        }
        return listaProcessos;
    }
    
    public Projeto select(int id_projeto) throws SQLException{
        PreparedStatement sql = ConexaoBd.getInstance().prepareStatement("SELECT nome, descricao, ativo FROM projeto WHERE id_projeto=?");
        sql.setInt(1, id_projeto);
        ResultSet rs = sql.executeQuery();
        if(rs.next()){
            Projeto projeto = new Projeto();
            projeto.setId(id_projeto);
            projeto.setNome(rs.getString("nome"));
            projeto.setDescricao(rs.getString("descricao"));
            projeto.setAtivo(rs.getBoolean("ativo"));
            projeto.setAprovadores(selectAprovadores(id_projeto));
            projeto.setGerentes(selectGerentes(id_projeto));
            projeto.setObservadores(selectObservadores(id_projeto));
            projeto.setParticipantes(selectParticipantes(id_projeto));
            return projeto;
        }
        return null;
    }
    
    public List<Usuario> selectGerentes(int id_projeto) throws SQLException{
        PreparedStatement sql = ConexaoBd.getInstance().prepareStatement("SELECT u.id_usuario, u.email, u.nome FROM usuarios_sistema u "
                + "INNER JOIN gerencia g ON u.id_usuario = g.id_usuario WHERE g.id_projeto = ?");
        sql.setInt(1, id_projeto);
        ResultSet rs = sql.executeQuery();
        List<Usuario> listaGerentes = new ArrayList<Usuario>();
        while(rs.next()){
            Usuario usuario = new Usuario();
            usuario.setId_usuario(rs.getInt("id_usuario"));
            usuario.setEmail(rs.getString("email"));
            usuario.setNome(rs.getString("nome"));
            listaGerentes.add(usuario);
        }
        return listaGerentes;
        
    }
    
    public List<Usuario> selectAprovadores(int id_projeto) throws SQLException{
        PreparedStatement sql = ConexaoBd.getInstance().prepareStatement("SELECT u.id_usuario, u.email, u.nome FROM usuarios_sistema AS u "
                + "INNER JOIN aprova AS a ON u.id_usuario = a.id_usuario WHERE a.id_projeto = ?");
        sql.setInt(1, id_projeto);
        ResultSet rs = sql.executeQuery();
        List<Usuario> listaAprovadores = new ArrayList<Usuario>();
        while(rs.next()){
            Usuario usuario = new Usuario();
            usuario.setId_usuario(rs.getInt("id_usuario"));
            usuario.setEmail(rs.getString("email"));
            usuario.setNome(rs.getString("nome"));
            listaAprovadores.add(usuario);
        }
        return listaAprovadores;
        
    }
    
    public List<Usuario> selectParticipantes(int id_projeto) throws SQLException{
        PreparedStatement sql = ConexaoBd.getInstance().prepareStatement("SELECT u.id_usuario, u.email, u.nome FROM usuarios_sistema u "
                + "INNER JOIN participa p ON u.id_usuario = p.id_usuario WHERE p.id_projeto = ?");
        sql.setInt(1, id_projeto);
        ResultSet rs = sql.executeQuery();
        List<Usuario> listaParticipantes = new ArrayList<Usuario>();
        while(rs.next()){
            Usuario usuario = new Usuario();
            usuario.setId_usuario(rs.getInt("id_usuario"));
            usuario.setEmail(rs.getString("email"));
            usuario.setNome(rs.getString("nome"));
            listaParticipantes.add(usuario);
        }
        return listaParticipantes;
        
    }
    
    public List<Usuario> selectObservadores(int id_projeto) throws SQLException{
        PreparedStatement sql = ConexaoBd.getInstance().prepareStatement("SELECT u.id_usuario, u.email, u.nome FROM usuarios_sistema u "
                + "INNER JOIN observa o ON u.id_usuario = o.id_usuario WHERE o.id_projeto = ?");
        sql.setInt(1, id_projeto);
        ResultSet rs = sql.executeQuery();
        List<Usuario> listaObservadores = new ArrayList<Usuario>();
        while(rs.next()){
            Usuario usuario = new Usuario();
            usuario.setId_usuario(rs.getInt("id_usuario"));
            usuario.setEmail(rs.getString("email"));
            usuario.setNome(rs.getString("nome"));
            listaObservadores.add(usuario);
        }
        return listaObservadores;
        
    }
    
    public void insertGerente(Projeto projeto, Usuario usuario) throws SQLException{
        PreparedStatement sql = ConexaoBd.getInstance().prepareStatement("INSERT INTO gerencia (id_projeto, id_usuario) VALUES (?, ?)");
        sql.setInt(1, projeto.getId());
        sql.setInt(2, usuario.getId_usuario());
        sql.execute();
    }
    
    public void insertAprovador(Projeto projeto, Usuario usuario) throws SQLException{
        PreparedStatement sql = ConexaoBd.getInstance().prepareStatement("INSERT INTO aprova (id_projeto, id_usuario) VALUES (?,?)");
        sql.setInt(1, projeto.getId());
        sql.setInt(2, usuario.getId_usuario());
        sql.execute();
    }
    
    public void insertParticipante(Projeto projeto, Usuario usuario) throws SQLException{
        PreparedStatement sql = ConexaoBd.getInstance().prepareStatement("INSERT INTO participa (id_projeto, id_usuario) VALUES (?,?)");
        sql.setInt(1, projeto.getId());
        sql.setInt(2, usuario.getId_usuario());
        sql.execute();
    }
    
    public void insertObservador(Projeto projeto, Usuario usuario) throws SQLException {
        PreparedStatement sql = ConexaoBd.getInstance().prepareStatement("INSERT INTO observa (id_projeto, id_usuario) VALUES (?,?)");
        sql.setInt(1, projeto.getId());
        sql.setInt(2, usuario.getId_usuario());
        sql.execute();
    }
    
    public void deleteAprovador(Projeto projeto, Usuario usuario) throws SQLException{
        PreparedStatement sql = ConexaoBd.getInstance().prepareStatement("DELETE FROM aprova WHERE id_usuario = ? AND id_projeto = ?");
        sql.setInt(1, projeto.getId());
        sql.setInt(2, usuario.getId_usuario());
        sql.execute();
    }
    
    public void deleteParticipante(Projeto projeto, Usuario usuario) throws SQLException{
        PreparedStatement sql = ConexaoBd.getInstance().prepareStatement("DELETE FROM participa WHERE id_usuario = ? AND id_projeto = ?");
        sql.setInt(1, projeto.getId());
        sql.setInt(2, usuario.getId_usuario());
        sql.execute();
    }
    
    public void deleteObservador(Projeto projeto, Usuario usuario) throws SQLException{
        PreparedStatement sql = ConexaoBd.getInstance().prepareStatement("DELETE FROM observa WHERE id_usuario = ? AND id_projeto = ?");
        sql.setInt(1, projeto.getId());
        sql.setInt(2, usuario.getId_usuario());
        sql.execute();
    }
    
    public void deleteGerente(Projeto projeto, Usuario usuario) throws SQLException{
        PreparedStatement sql = ConexaoBd.getInstance().prepareStatement("DELETE FROM gerencia WHERE id_usuario = ? AND id_projeto = ?");
        sql.setInt(1, projeto.getId());
        sql.setInt(2, usuario.getId_usuario());
        sql.execute();
    }
}
