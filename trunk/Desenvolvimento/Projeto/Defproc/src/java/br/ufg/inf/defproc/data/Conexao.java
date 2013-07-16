package br.ufg.inf.defproc.data;

import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.SQLException;

/**
 *
 * @author Jonathan Silva Pereira
 */
public class Conexao {
    
    String driver = "org.postgresql.Driver";
    String user, password, url;
    
    public Conexao(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
        boolean iniciarConexao = iniciarConexao();
    }
    
    private boolean iniciarConexao() {
        try {
            Class.forName(driver);
            Connection con = null;
            con = (Connection) DriverManager.getConnection(url, user, password);
            return true;
        }
        catch (ClassNotFoundException e) {
            System.err.print(e.getMessage());
            return false;
        } 
        catch (SQLException e) {
            System.err.print(e.getMessage());
            return false;
        }
    }
    
}
