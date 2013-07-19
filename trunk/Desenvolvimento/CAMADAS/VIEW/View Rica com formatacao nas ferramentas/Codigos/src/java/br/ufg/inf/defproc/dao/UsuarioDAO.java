/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.inf.defproc.dao;

import br.ufg.inf.defproc.factory.ConexaoBd;
import br.ufg.inf.defproc.model.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Pedro Felipe''
 */
public class UsuarioDAO {

    public void insert(Usuario usuario) throws SQLException {

        PreparedStatement sql = ConexaoBd.getInstance().prepareStatement("INSERT INTO usuarios_sistema (email, senha, nome) "
                + "VALUES (?,?,?)");
        sql.setString(1, usuario.getEmail());
        sql.setString(2, usuario.getPassword());
        sql.setString(3, usuario.getNome());
        
        sql.execute();
    }
    
    public List<Usuario> select() throws SQLException{
        PreparedStatement sql = ConexaoBd.getInstance().prepareStatement("SELECT id_usuario, email, nome FROM usuarios_sistema WHERE admin = 'f'");
        ResultSet rs = sql.executeQuery();
        List<Usuario> listaUsuarios = new ArrayList<Usuario>();
        while(rs.next()){
            Usuario usuario = new Usuario();
            usuario.setId_usuario(rs.getInt("id_usuario"));
            usuario.setEmail(rs.getString("email"));
            usuario.setNome(rs.getString("nome"));
            usuario.setAdmin(false);
            
            listaUsuarios.add(usuario);
        }
        return listaUsuarios;
    }
    
    public Usuario select(String email) throws SQLException{
        PreparedStatement sql = ConexaoBd.getInstance().prepareStatement("SELECT id_usuario, nome, senha, admin FROM usuarios_sistema WHERE email = ?");
        sql.setString(1, email);
        ResultSet rs = sql.executeQuery();
        if(rs.next()){
            Usuario usuario = new Usuario();
            usuario.setEmail(email);
            usuario.setId_usuario(rs.getInt("id_usuario"));
            usuario.setNome(rs.getString("nome"));
            usuario.setHash(rs.getString("senha"));
            usuario.setAdmin(rs.getBoolean("admin"));
            return usuario;
        }
        return null;
    }
    
    public Usuario select(int id) throws SQLException{
        PreparedStatement sql = ConexaoBd.getInstance().prepareStatement("SELECT nome, email, admin FROM usuarios_sistema WHERE id_usuario = ?");
        sql.setInt(1, id);
        ResultSet rs = sql.executeQuery();
        if(rs.next()){
            Usuario usuario = new Usuario();
            usuario.setEmail(rs.getString("email"));
            usuario.setId_usuario(id);
            usuario.setNome(rs.getString("nome"));
            usuario.setAdmin(rs.getBoolean("admin"));
            return usuario;
        }
        return null;
    }
}
