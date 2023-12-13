/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author solam
 */
@Entity
@Table(name = "conta_bancaria")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ContaBancaria.findAll", query = "SELECT c FROM ContaBancaria c"),
    @NamedQuery(name = "ContaBancaria.findByIdCc", query = "SELECT c FROM ContaBancaria c WHERE c.idCc = :idCc"),
    @NamedQuery(name = "ContaBancaria.findByCodBanco", query = "SELECT c FROM ContaBancaria c WHERE c.codBanco = :codBanco"),
    @NamedQuery(name = "ContaBancaria.findByAgenciaConta", query = "SELECT c FROM ContaBancaria c WHERE c.agenciaConta = :agenciaConta"),
    @NamedQuery(name = "ContaBancaria.findByNumeroConta", query = "SELECT c FROM ContaBancaria c WHERE c.numeroConta = :numeroConta"),
    @NamedQuery(name = "ContaBancaria.findByChavePix", query = "SELECT c FROM ContaBancaria c WHERE c.chavePix = :chavePix")})
public class ContaBancaria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_cc")
    private Integer idCc;
    @Basic(optional = false)
    @Column(name = "cod_banco")
    private String codBanco;
    @Basic(optional = false)
    @Column(name = "agencia_conta")
    private String agenciaConta;
    @Basic(optional = false)
    @Column(name = "numero_conta")
    private String numeroConta;
    @Basic(optional = false)
    @Column(name = "chave_pix")
    private String chavePix;
    @JoinColumn(name = "fk_email", referencedColumnName = "usuario_email")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Organizacao fkEmail;

    public ContaBancaria() {
    }

    public ContaBancaria(Integer idCc) {
        this.idCc = idCc;
    }

    public ContaBancaria(Integer idCc, String codBanco, String agenciaConta, String numeroConta, String chavePix) {
        this.idCc = idCc;
        this.codBanco = codBanco;
        this.agenciaConta = agenciaConta;
        this.numeroConta = numeroConta;
        this.chavePix = chavePix;
    }

    public Integer getIdCc() {
        return idCc;
    }

    public void setIdCc(Integer idCc) {
        this.idCc = idCc;
    }

    public String getCodBanco() {
        return codBanco;
    }

    public void setCodBanco(String codBanco) {
        this.codBanco = codBanco;
    }

    public String getAgenciaConta() {
        return agenciaConta;
    }

    public void setAgenciaConta(String agenciaConta) {
        this.agenciaConta = agenciaConta;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public String getChavePix() {
        return chavePix;
    }

    public void setChavePix(String chavePix) {
        this.chavePix = chavePix;
    }

    public Organizacao getFkEmail() {
        return fkEmail;
    }

    public void setFkEmail(Organizacao fkEmail) {
        this.fkEmail = fkEmail;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCc != null ? idCc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ContaBancaria)) {
            return false;
        }
        ContaBancaria other = (ContaBancaria) object;
        if ((this.idCc == null && other.idCc != null) || (this.idCc != null && !this.idCc.equals(other.idCc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.ContaBancaria[ idCc=" + idCc + " ]";
    }
    
}
