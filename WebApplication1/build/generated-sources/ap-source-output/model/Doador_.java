package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Acesso;
import model.Doacao;
import model.Endereco;
import model.Organizacao;

@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2023-12-12T21:53:46")
@StaticMetamodel(Doador.class)
public class Doador_ { 

    public static volatile SingularAttribute<Doador, String> telefone;
    public static volatile SingularAttribute<Doador, Acesso> acesso;
    public static volatile SingularAttribute<Doador, Organizacao> organizacao;
    public static volatile CollectionAttribute<Doador, Endereco> enderecoCollection;
    public static volatile SingularAttribute<Doador, String> nome;
    public static volatile CollectionAttribute<Doador, Doacao> doacaoCollection;
    public static volatile SingularAttribute<Doador, String> userType;
    public static volatile SingularAttribute<Doador, String> email;
    public static volatile SingularAttribute<Doador, String> imagemUrl;

}