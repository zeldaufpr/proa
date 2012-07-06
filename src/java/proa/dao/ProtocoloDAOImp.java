/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package proa.dao;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import proa.controller.Mensagem;
import proa.model.Protocolo;
import proa.utils.HibernateUtil;

/**
 *
 * @author Administrador
 */
public class ProtocoloDAOImp extends Mensagem implements ProtocoloDAO {

    private Session sessao = null;

    @Override
    public List<Protocolo> listarProtocolo() {
         sessao = HibernateUtil.getSessionFactory().getCurrentSession();
        List lista = null;
        try {
            sessao.beginTransaction();
   //         lista = sessao.createQuery("from Estudante e WHERE e.curso = '" + nome + "' order by e.nome").list();
        } catch (HibernateException e) {
            
        } finally {
            sessao.beginTransaction().commit();
            sessao = null;
            return lista;
        }
    }

    public void cadastrarProtocolo(Protocolo protocolo) {
        try {
            sessao = HibernateUtil.getSessionFactory().getCurrentSession();
            sessao.beginTransaction();
            sessao.save(protocolo);
            sessao.getTransaction().commit();

        } catch (HibernateException e) {
            sessao.getTransaction().rollback();
        }
        finally {
     
        }
    }


}
