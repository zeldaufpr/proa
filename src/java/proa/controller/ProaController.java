/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proa.controller;

import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import proa.dao.ProtocoloDAO;
import proa.dao.ProtocoloDAOImp;

/**
 *
 * @author paulohsam
 */

@ManagedBean
@SessionScoped

public class ProaController implements Serializable{
    
    public String paginaPrincipal = "";
    /* Lista os protocolos do PROA, compartilhado por todos */
    private static DataModel listaProtocolo;
    private FacesMessage mensagem;

    /** Creates a new instance of PrincipalController */
    public ProaController() {
    }

    public void mensagem(String msg1, String msg2) {
        mensagem = new FacesMessage(FacesMessage.SEVERITY_INFO, msg1, msg2);
        FacesContext.getCurrentInstance().addMessage(null, mensagem);
    }

    public DataModel getListaProtocolo() {
        return this.listaProtocolo;
    }

    public void setListProtocolo(List protocolo) {
        listaProtocolo = new ListDataModel(protocolo);
    }

    public String getPaginaPrincipal() {
        return paginaPrincipal;
    }

    public void setPaginaPrincipal(String paginaPrincipal) {
        this.paginaPrincipal = paginaPrincipal;
    }

    public void setPaginaBranca() {
        this.paginaPrincipal = "";
    }
}
