/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author solam
 */
@Entity
@Table(name = "organizacao")
@NamedQueries({
    @NamedQuery(name = "Organizacao.findAll", query = "SELECT o FROM Organizacao o"),
    @NamedQuery(name = "Organizacao.findByUsuarioEmail", query = "SELECT o FROM Organizacao o WHERE o.usuarioEmail = :usuarioEmail"),
    @NamedQuery(name = "Organizacao.findBySite", query = "SELECT o FROM Organizacao o WHERE o.site = :site"),
    @NamedQuery(name = "Organizacao.findByMissao", query = "SELECT o FROM Organizacao o WHERE o.missao = :missao"),
    @NamedQuery(name = "Organizacao.findByCategoria", query = "SELECT o FROM Organizacao o WHERE o.categoria = :categoria"),
    @NamedQuery(name = "Organizacao.findByDataCadastro", query = "SELECT o FROM Organizacao o WHERE o.dataCadastro = :dataCadastro")})
public class Organizacao implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "organizacaoUsuarioEmail")
    private Collection<Doacao> doacaoCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "usuario_email")
    private String usuarioEmail;
    @Column(name = "site")
    private String site;
    @Basic(optional = false)
    @Column(name = "missao")
    private String missao;
    @Basic(optional = false)
    @Column(name = "categoria")
    private String categoria;
    @Basic(optional = false)
    @Column(name = "dataCadastro")
    @Temporal(TemporalType.DATE)
    private Date dataCadastro;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkEmail", fetch = FetchType.EAGER)
    private Collection<ContaBancaria> contaBancariaCollection;
    @JoinColumn(name = "usuario_email", referencedColumnName = "email", insertable = false, updatable = false)
    @OneToOne(optional = false, fetch = FetchType.EAGER)
    private Doador doador;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkEmail", fetch = FetchType.EAGER)
    private Collection<Noticia> noticiaCollection;

    public Organizacao() {
    }

    public Organizacao(String usuarioEmail) {
        this.usuarioEmail = usuarioEmail;
    }

    public Organizacao(String usuarioEmail, String missao, String categoria, Date dataCadastro) {
        this.usuarioEmail = usuarioEmail;
        this.missao = missao;
        this.categoria = categoria;
        this.dataCadastro = dataCadastro;
    }

    public String getUsuarioEmail() {
        return usuarioEmail;
    }

    public void setUsuarioEmail(String usuarioEmail) {
        this.usuarioEmail = usuarioEmail;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getMissao() {
        return missao;
    }

    public void setMissao(String missao) {
        this.missao = missao;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Collection<ContaBancaria> getContaBancariaCollection() {
        return contaBancariaCollection;
    }

    public void setContaBancariaCollection(Collection<ContaBancaria> contaBancariaCollection) {
        this.contaBancariaCollection = contaBancariaCollection;
    }

    public Doador getDoador() {
        return doador;
    }

    public void setDoador(Doador doador) {
        this.doador = doador;
    }

    public Collection<Noticia> getNoticiaCollection() {
        return noticiaCollection;
    }

    public void setNoticiaCollection(Collection<Noticia> noticiaCollection) {
        this.noticiaCollection = noticiaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuarioEmail != null ? usuarioEmail.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Organizacao)) {
            return false;
        }
        Organizacao other = (Organizacao) object;
        if ((this.usuarioEmail == null && other.usuarioEmail != null) || (this.usuarioEmail != null && !this.usuarioEmail.equals(other.usuarioEmail))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Organizacao[ usuarioEmail=" + usuarioEmail + " ]";
    }

    public Collection<Doacao> getDoacaoCollection() {
        return doacaoCollection;
    }

    public void setDoacaoCollection(Collection<Doacao> doacaoCollection) {
        this.doacaoCollection = doacaoCollection;
    }
    
}
