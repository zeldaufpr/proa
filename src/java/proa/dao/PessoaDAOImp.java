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
import proa.model.Pessoa;
import proa.utils.HibernateUtil;

/**
 *
 * @author Administrador
 */
public class PessoaDAOImp implements PessoaDAO, Serializable {

    private Session sessao = null;

    @Override
    public Pessoa getPessoaCPF(String cpf) {

        sessao = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transacao = sessao.beginTransaction();
        Criteria criteria = sessao.createCriteria(Pessoa.class);
        criteria.add(Restrictions.eq("cpf", cpf));
        Pessoa pess = (Pessoa) criteria.uniqueResult();
        transacao.commit();
        return pess;
        
    }


}
