package proa.model;
// Generated 02/06/2012 15:52:47 by Hibernate Tools 3.2.1.GA


import java.util.HashSet;
import java.util.Set;

/**
 * Servidor generated by hbm2java
 */
public class Servidor  implements java.io.Serializable {


     private Integer id;
     private Pessoa pessoa;
     private String siape;
     private String siad;
     private String tipo;
     private String nivelGraduacao;
     private String ramal;
     private String lotacao;
     private String setor;
     private String graduacao;
     private String especializacao;
     private String mestrado;
     private String doutorado;
     private String situacao;
     private String cargo;
     private Set protocolos = new HashSet(0);
     private Set atendimentos = new HashSet(0);
     private Set tecnicoadministrativos = new HashSet(0);
     private Set protocoloServidors = new HashSet(0);
     private Set professors = new HashSet(0);

    public Servidor() {
    }

    public Servidor(Pessoa pessoa, String siape, String siad, String tipo, String nivelGraduacao, String ramal, String lotacao, String setor, String graduacao, String especializacao, String mestrado, String doutorado, String situacao, String cargo, Set protocolos, Set atendimentos, Set tecnicoadministrativos, Set protocoloServidors, Set professors) {
       this.pessoa = pessoa;
       this.siape = siape;
       this.siad = siad;
       this.tipo = tipo;
       this.nivelGraduacao = nivelGraduacao;
       this.ramal = ramal;
       this.lotacao = lotacao;
       this.setor = setor;
       this.graduacao = graduacao;
       this.especializacao = especializacao;
       this.mestrado = mestrado;
       this.doutorado = doutorado;
       this.situacao = situacao;
       this.cargo = cargo;
       this.protocolos = protocolos;
       this.atendimentos = atendimentos;
       this.tecnicoadministrativos = tecnicoadministrativos;
       this.protocoloServidors = protocoloServidors;
       this.professors = professors;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public Pessoa getPessoa() {
        return this.pessoa;
    }
    
    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
    public String getSiape() {
        return this.siape;
    }
    
    public void setSiape(String siape) {
        this.siape = siape;
    }
    public String getSiad() {
        return this.siad;
    }
    
    public void setSiad(String siad) {
        this.siad = siad;
    }
    public String getTipo() {
        return this.tipo;
    }
    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public String getNivelGraduacao() {
        return this.nivelGraduacao;
    }
    
    public void setNivelGraduacao(String nivelGraduacao) {
        this.nivelGraduacao = nivelGraduacao;
    }
    public String getRamal() {
        return this.ramal;
    }
    
    public void setRamal(String ramal) {
        this.ramal = ramal;
    }
    public String getLotacao() {
        return this.lotacao;
    }
    
    public void setLotacao(String lotacao) {
        this.lotacao = lotacao;
    }
    public String getSetor() {
        return this.setor;
    }
    
    public void setSetor(String setor) {
        this.setor = setor;
    }
    public String getGraduacao() {
        return this.graduacao;
    }
    
    public void setGraduacao(String graduacao) {
        this.graduacao = graduacao;
    }
    public String getEspecializacao() {
        return this.especializacao;
    }
    
    public void setEspecializacao(String especializacao) {
        this.especializacao = especializacao;
    }
    public String getMestrado() {
        return this.mestrado;
    }
    
    public void setMestrado(String mestrado) {
        this.mestrado = mestrado;
    }
    public String getDoutorado() {
        return this.doutorado;
    }
    
    public void setDoutorado(String doutorado) {
        this.doutorado = doutorado;
    }
    public String getSituacao() {
        return this.situacao;
    }
    
    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }
    public String getCargo() {
        return this.cargo;
    }
    
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    public Set getProtocolos() {
        return this.protocolos;
    }
    
    public void setProtocolos(Set protocolos) {
        this.protocolos = protocolos;
    }
    public Set getAtendimentos() {
        return this.atendimentos;
    }
    
    public void setAtendimentos(Set atendimentos) {
        this.atendimentos = atendimentos;
    }
    public Set getTecnicoadministrativos() {
        return this.tecnicoadministrativos;
    }
    
    public void setTecnicoadministrativos(Set tecnicoadministrativos) {
        this.tecnicoadministrativos = tecnicoadministrativos;
    }
    public Set getProtocoloServidors() {
        return this.protocoloServidors;
    }
    
    public void setProtocoloServidors(Set protocoloServidors) {
        this.protocoloServidors = protocoloServidors;
    }
    public Set getProfessors() {
        return this.professors;
    }
    
    public void setProfessors(Set professors) {
        this.professors = professors;
    }




}


