package model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Organizacao;

@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2023-12-12T21:53:46")
@StaticMetamodel(Noticia.class)
public class Noticia_ { 

    public static volatile SingularAttribute<Noticia, Integer> idNoticia;
    public static volatile SingularAttribute<Noticia, String> imgUrl;
    public static volatile SingularAttribute<Noticia, Date> data;
    public static volatile SingularAttribute<Noticia, Organizacao> fkEmail;
    public static volatile SingularAttribute<Noticia, String> titulo;
    public static volatile SingularAttribute<Noticia, String> descricao;

}