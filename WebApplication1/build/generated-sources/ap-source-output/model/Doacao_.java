package model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Doador;
import model.Organizacao;

@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2023-12-13T00:57:23")
@StaticMetamodel(Doacao.class)
public class Doacao_ { 

    public static volatile SingularAttribute<Doacao, Date> dataDoacao;
    public static volatile SingularAttribute<Doacao, Doador> doadorEmail;
    public static volatile SingularAttribute<Doacao, Float> valor;
    public static volatile SingularAttribute<Doacao, Organizacao> organizacaoUsuarioEmail;
    public static volatile SingularAttribute<Doacao, Integer> idDoacao;

}