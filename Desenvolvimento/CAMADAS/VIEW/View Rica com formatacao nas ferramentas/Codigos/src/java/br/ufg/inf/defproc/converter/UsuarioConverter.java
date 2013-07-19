/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.inf.defproc.converter;

import br.ufg.inf.defproc.dao.UsuarioDAO;
import br.ufg.inf.defproc.model.Usuario;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author pedro.teles
 */
@FacesConverter(value = "usuarioConverter")
public class UsuarioConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        try {            
            Usuario usuario = usuarioDAO.select(Integer.parseInt(string));            
            return usuario;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioConverter.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        if(o instanceof Usuario){
            return o.toString();
        }
        return null;
    }
    
}
