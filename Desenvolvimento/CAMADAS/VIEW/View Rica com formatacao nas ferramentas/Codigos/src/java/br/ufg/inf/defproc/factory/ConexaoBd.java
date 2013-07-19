/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.inf.defproc.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pedro Felipe''
 */
public class ConexaoBd {
    
    private static Connection instancia;
    
    private ConexaoBd() throws SQLException{
        try {
            Class.forName("org.postgresql.Driver");
            instancia = DriverManager.getConnection("jdbc:postgresql://localhost:5433/defproc", "postgres", "postgres");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConexaoBd.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    public static Connection getInstance() throws SQLException{
        if(instancia == null){
            new ConexaoBd();
        }
        return instancia;
    }
    
}
