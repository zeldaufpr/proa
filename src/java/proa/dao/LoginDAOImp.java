/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package proa.dao;

import java.util.List;
import proa.model.Login;
import proa.utils.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author paulohsam
 */
public class LoginDAOImp implements LoginDAO {

    Session sessao = null;
     
    @Override
    
    public Login getUsuarioByLogin(String cpfPessoa) throws HibernateException {
        List <Login> lista = null;
        Login login = null;
        try {
           sessao = HibernateUtil.getSessionFactory().getCurrentSession();
           sessao.beginTransaction();
           lista = sessao.createQuery("FROM Login l WHERE l.pessoa = '" + cpfPessoa + "'" ).list();
           login = lista.iterator().next();

        } catch (Exception e) {
             throw e;
        } finally {
            sessao.beginTransaction().commit();
            sessao = null;
            return login;
        }
    }

    @Override
    public void verificaAcesso() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
