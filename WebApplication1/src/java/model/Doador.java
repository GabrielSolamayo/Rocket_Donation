/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author solam
 */
@Entity
@Table(name = "doador")
@NamedQueries({
    @NamedQuery(name = "Doador.findAll", query = "SELECT d FROM Doador d"),
    @NamedQuery(name = "Doador.findByEmail", query = "SELECT d FROM Doador d WHERE d.email = :email"),
    @NamedQuery(name = "Doador.findByNome", query = "SELECT d FROM Doador d WHERE d.nome = :nome"),
    @NamedQuery(name = "Doador.findByTelefone", query = "SELECT d FROM Doador d WHERE d.telefone = :telefone"),
    @NamedQuery(name = "Doador.findByUserType", query = "SELECT d FROM Doador d WHERE d.userType = :userType")})
public class Doador implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;
    @Basic(optional = false)
    @Column(name = "telefone")
    private String telefone;
    @Basic(optional = false)
    @Column(name = "userType")
    private String userType;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "doador", fetch = FetchType.EAGER)
    private Acesso acesso;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkEmail", fetch = FetchType.EAGER)
    private Collection<Endereco> enderecoCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "doador", fetch = FetchType.EAGER)
    private Organizacao organizacao;

    public Doador() {
    }

    public Doador(String email) {
        this.email = email;
    }

    public Doador(String email, String nome, String telefone, String userType) {
        this.email = email;
        this.nome = nome;
        this.telefone = telefone;
        this.userType = userType;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public Acesso getAcesso() {
        return acesso;
    }

    public void setAcesso(Acesso acesso) {
        this.acesso = acesso;
    }

    public Collection<Endereco> getEnderecoCollection() {
        return enderecoCollection;
    }

    public void setEnderecoCollection(Collection<Endereco> enderecoCollection) {
        this.enderecoCollection = enderecoCollection;
    }

    public Organizacao getOrganizacao() {
        return organizacao;
    }

    public void setOrganizacao(Organizacao organizacao) {
        this.organizacao = organizacao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (email != null ? email.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Doador)) {
            return false;
        }
        Doador other = (Doador) object;
        if ((this.email == null && other.email != null) || (this.email != null && !this.email.equals(other.email))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Doador[ email=" + email + " ]";
    }
    
}
