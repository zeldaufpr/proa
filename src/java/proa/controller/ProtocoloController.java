/* Bean gerenciado JSF
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proa.controller;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import proa.dao.PessoaDAO;
import proa.dao.PessoaDAOImp;
import proa.dao.ProtocoloDAO;
import proa.dao.ProtocoloDAOImp;
import proa.dao.ServidorDAO;
import proa.dao.ServidorDAOImp;
import proa.model.Pessoa;
import proa.model.Protocolo;
import proa.model.ProtocoloServidor;
import proa.model.Servidor;

/**
 *
 * @author paulohsam
 */
@ManagedBean
@SessionScoped

public class ProtocoloController extends ProaController implements Serializable {

    /** Creates a new instance of ProtocoloController */
    private boolean teste;
    private Protocolo proto = new Protocolo();
    public Protocolo protosel;
    private Pessoa paciente = new Pessoa();
    private Pessoa solicitante = new Pessoa();
    private List<Protocolo> lista;
    private ProtocoloServidor protoServ = new ProtocoloServidor();
    private Servidor servo = new Servidor();
    private boolean telaDados = false;
    ProaController proa;
    private ProtocoloDAO protocoloDAO = new ProtocoloDAOImp();
    private PessoaDAO pessoaDAO = new PessoaDAOImp();



   // public DataModel getListaProtocolo() {
       
   // }

    public String cadastroProtocolo(ProaController proa) {
       this.proa = proa;
        this.proa.setPaginaPrincipal("cadastroProtocolo.xhtml");
        return "PRINCIPAL";
    }

    public String triagemProtocolo(ProaController principal) {
        proa = principal;
        proa.setPaginaPrincipal("triarProtocolo.xhtml");
        return "PRINCIPAL";
    }

    //inicializar no construtor os relacionamentos um/muitos
    public ProtocoloController() {
        proto.setPessoaByCpfPaciente(paciente);
        proto.setPessoaByCpfSolicitante(solicitante);
        protoServ.setProtocolo(proto);
        protoServ.setServidor(servo);
    }

    public String telaTriar(ProaController principal) {
        principal.setPaginaPrincipal("triarProtocolo.xhtml");
        return "principal";
    }

    public Protocolo getProtosel() {
        return protosel;
    }

    public void setProtosel(Protocolo protosel) {
        this.protosel = protosel;
    }

    public Pessoa getPaciente() {

        return paciente;
    }

    public void setPaciente(Pessoa paciente) {
        this.paciente = paciente;
    }

    public Pessoa getSolicitante() {

        return solicitante;
    }

    public void setSolicitante(Pessoa solicitante) {
        this.solicitante = solicitante;
    }

    public Protocolo getProto() {
        return proto;
    }

    public void setProto(Protocolo proto) {
        this.proto = proto;
    }

    public boolean isTeste() {
        return teste;
    }

    public void setTeste(boolean teste) {
        this.teste = teste;
    }

    public void setTelaDados(boolean dados) {
        telaDados = dados;
    }

    public boolean isTeste2() {
        return telaDados;
    }

    public void buscaPorCpfPaciente() {
            telaDados = false;
        Pessoa pessoa = pessoaDAO.getPessoaCPF(proto.getPessoaByCpfPaciente().getCpf());

//        Servidor servo = daoS.getServidorCpf(pessoa1.getCpf());
        if (pessoa != null) {
            proto.setPessoaByCpfPaciente(pessoa);
            telaDados = true;
        }
    }

    public void buscaPorCpfSolicitante() {
        telaDados = false;
        Pessoa pessoa = pessoaDAO.getPessoaCPF(proto.getPessoaByCpfSolicitante().getCpf());

//        Servidor servo = daoS.getServidorCpf(pessoa1.getCpf());
        if (pessoa != null) {
            proto.setPessoaByCpfSolicitante(pessoa);
            telaDados = true;
        }
    }


    public String  cadastrarProtocolo() {
        Date data = new Date();
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
        formatador.format(data);
        proto.setDataCriacao(data);
        proto.setSituacao("PENDENTE");
        proto.setProtocolo("1/2012");
        protocoloDAO.cadastrarProtocolo(proto);
        proa.setPaginaBranca();
        mensagem("SUCESSO NA OPERACAO","ENCAMINHADO COM SUCESSO");
        return "SUCESSO";

    }
}
