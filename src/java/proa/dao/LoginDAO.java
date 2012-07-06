/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package proa.dao;

import java.util.List;
import org.hibernate.HibernateException;
import proa.model.Login;

/**
 *
 * @author paulohsam
 */
public interface LoginDAO {

    public Login getUsuarioByLogin(String login) throws HibernateException;
    public void verificaAcesso ();

}
