/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proa.controller;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import javax.xml.ws.http.HTTPException;
import org.hibernate.HibernateException;
import org.hibernate.SessionException;
import proa.dao.LoginDAO;
import proa.dao.LoginDAOImp;
import proa.model.Login;
import proa.model.LoginGrupo;
import proa.model.Pessoa;

/**
 *
 * @author paulohsam
 */
@ManagedBean
@SessionScoped

public class LoginController extends ProaController implements Serializable {

    /** Creates a new instance of UsuarioController */
    public LoginController() {
        login.setPessoa(pessoa);
    }

    private Pessoa pessoa = new Pessoa();
    private LoginDAO dao = new LoginDAOImp();
    Login login = new Login();
    // Variavel setada na aba do carrosel, neste caso fica fixa PROA
    private String setorLogin = "PROA";
    String cpfLogin = "";
    String senha = "";

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String vefificaAcesso() {
        return null;
    }


    public String getCpfLogin() {
        return cpfLogin;
    }

    public void setCpfLogin(String cpfLogin) {
        this.cpfLogin = cpfLogin;
    }

    private String buscarPrivilegio(Login login) {
        String privilegio = "";
        Set <LoginGrupo> loginGrupo = login.getLoginGrupos();
        for (LoginGrupo lg : loginGrupo) {
            if (lg.getGrupos().getDescricao().equalsIgnoreCase(setorLogin)) 
                privilegio = lg.getPrivilegio();
        }
        return privilegio;



    }

    public String efetuarLogin() {
        setPaginaBranca();
        try {
            login = dao.getUsuarioByLogin(cpfLogin);
            if (cpfLogin != null || cpfLogin.equals("")) {
                if (login.getSenha().equals(senha) && !senha.equals("")) {
                    //////////////////////////BUSCAR PRIVILEGIOS//////////////////////////////////////////////////////////////////
                    String privilegio = buscarPrivilegio(login);
                    ///////////////////////////////USUARIO ENCONTRADO NO SETOR////////////////////////////////////////////////////
                    if (!privilegio.equalsIgnoreCase("")) {
                        //////////////////////////USUARIO VAI SER INSERIDO NA SESSAO///////////////////////////////////////////////////
                        HttpSession httpSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
                        httpSession.setAttribute("usuario", login.getPessoa());
                        httpSession.setAttribute("privilegio", privilegio);
                       ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                        mensagem("SUCESSO NA OPERACAO", "BEM VINDO " + login.getPessoa().getNome());
                        return "SUCESSO";
                    } else {
                        mensagem("FALHA NA OPERACAO", "ACESSO NEGADO AO SETOR");
                        return "FALHA";
                    }


                } else {
                    mensagem("FALHA NA OPERACAO", "SENHA INVALIDA");
                    return "FALHA";
                }
            } else {
                mensagem("FALHA NA OPERACAO", "USUARIO INVALIDO");
                return "FALHA";
            }
        } catch (SessionException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, "FALHA DE SESSAO", ex);
            mensagem("FALHA NA OPERACAO", "ENTRE EM CONTATO COM ADMINISTRADOR DO SISTEMA - ERRO: 100");
            return "FALHA";

        } catch (HibernateException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, "FALHA DE BANCO DE DADOS", ex);
            mensagem("FALHA NA OPERACAO", "ENTRE EM CONTATO COM ADMINISTRADOR DO SISTEMA - ERRO: 101");
            return "FALHA";
        }
     }
}
