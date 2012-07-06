/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package proa.controller;


import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import proa.dao.PessoaDAO;
import proa.dao.PessoaDAOImp;
import proa.dao.ServidorDAO;
import proa.dao.ServidorDAOImp;
import proa.model.Pessoa;
import proa.model.Servidor;

/**
 *
 * @author Administrador
 */
@ManagedBean
@SessionScoped

public class PessoaController implements Serializable{

    /** Creates a new instance of PessoaController */
    public PessoaController() {
    }
    private Pessoa pessoa = new Pessoa();
    private Servidor servo = new Servidor();

    public Servidor getServo() {
        return servo;
    }

    public void setServo(Servidor servo) {
        this.servo = servo;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Pessoa buscaPorCpf(){
        PessoaDAO dao = new PessoaDAOImp();
        ServidorDAO daoS = new ServidorDAOImp();

        Pessoa pessoa1 = dao.getPessoaCPF(pessoa.getCpf());

        servo = daoS.getServidorCpf(pessoa1.getCpf());


        pessoa = pessoa1;
        return pessoa;

    }
}
