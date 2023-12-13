package model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.ContaBancaria;
import model.Doacao;
import model.Doador;
import model.Noticia;

@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2023-12-13T00:57:23")
@StaticMetamodel(Organizacao.class)
public class Organizacao_ { 

    public static volatile SingularAttribute<Organizacao, String> localImagem;
    public static volatile SingularAttribute<Organizacao, String> site;
    public static volatile SingularAttribute<Organizacao, String> usuarioEmail;
    public static volatile SingularAttribute<Organizacao, String> missao;
    public static volatile SingularAttribute<Organizacao, String> categoria;
    public static volatile SingularAttribute<Organizacao, String> descOrg;
    public static volatile CollectionAttribute<Organizacao, Doacao> doacaoCollection;
    public static volatile CollectionAttribute<Organizacao, Noticia> noticiaCollection;
    public static volatile SingularAttribute<Organizacao, Date> dataCadastro;
    public static volatile CollectionAttribute<Organizacao, ContaBancaria> contaBancariaCollection;
    public static volatile SingularAttribute<Organizacao, Doador> doador;

}