/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author solam
 */
@Entity
@Table(name = "doacao")
@NamedQueries({
    @NamedQuery(name = "Doacao.findAll", query = "SELECT d FROM Doacao d"),
    @NamedQuery(name = "Doacao.findByDataDoacao", query = "SELECT d FROM Doacao d WHERE d.dataDoacao = :dataDoacao"),
    @NamedQuery(name = "Doacao.findByValor", query = "SELECT d FROM Doacao d WHERE d.valor = :valor"),
    @NamedQuery(name = "Doacao.findByIdDoacao", query = "SELECT d FROM Doacao d WHERE d.idDoacao = :idDoacao")})
public class Doacao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "data_doacao")
    @Temporal(TemporalType.DATE)
    private Date dataDoacao;
    @Basic(optional = false)
    @Column(name = "valor")
    private float valor;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idDoacao")
    private Integer idDoacao;
    @JoinColumn(name = "doador_email", referencedColumnName = "email")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Doador doadorEmail;
    @JoinColumn(name = "organizacao_usuario_email", referencedColumnName = "usuario_email")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Organizacao organizacaoUsuarioEmail;

    public Doacao() {
    }

    public Doacao(Integer idDoacao) {
        this.idDoacao = idDoacao;
    }

    public Doacao(Integer idDoacao, Date dataDoacao, float valor) {
        this.idDoacao = idDoacao;
        this.dataDoacao = dataDoacao;
        this.valor = valor;
    }

    public Date getDataDoacao() {
        return dataDoacao;
    }

    public void setDataDoacao(Date dataDoacao) {
        this.dataDoacao = dataDoacao;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public Integer getIdDoacao() {
        return idDoacao;
    }

    public void setIdDoacao(Integer idDoacao) {
        this.idDoacao = idDoacao;
    }

    public Doador getDoadorEmail() {
        return doadorEmail;
    }

    public void setDoadorEmail(Doador doadorEmail) {
        this.doadorEmail = doadorEmail;
    }

    public Organizacao getOrganizacaoUsuarioEmail() {
        return organizacaoUsuarioEmail;
    }

    public void setOrganizacaoUsuarioEmail(Organizacao organizacaoUsuarioEmail) {
        this.organizacaoUsuarioEmail = organizacaoUsuarioEmail;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDoacao != null ? idDoacao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Doacao)) {
            return false;
        }
        Doacao other = (Doacao) object;
        if ((this.idDoacao == null && other.idDoacao != null) || (this.idDoacao != null && !this.idDoacao.equals(other.idDoacao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Doacao[ idDoacao=" + idDoacao + " ]";
    }
    
}
