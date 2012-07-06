/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package proa.dao;

import java.io.Serializable;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import proa.model.Servidor;
import proa.utils.HibernateUtil;

/**
 *
 * @author Administrador
 */
public class ServidorDAOImp implements ServidorDAO, Serializable {

    private Session sessao = null;
    
    @Override
    public Servidor getServidorCpf(String cpf) {

        sessao = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transacao = sessao.beginTransaction();
        Criteria criteria = sessao.createCriteria(Servidor.class);
        criteria.add(Restrictions.eq("cpf", cpf));
        Servidor ser = (Servidor) criteria.uniqueResult();
        transacao.commit();
        return ser;
    }

}
