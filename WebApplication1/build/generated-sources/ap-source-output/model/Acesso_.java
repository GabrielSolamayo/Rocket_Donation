package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Doador;

@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2023-12-13T14:48:21")
@StaticMetamodel(Acesso.class)
public class Acesso_ { 

    public static volatile SingularAttribute<Acesso, String> senha;
    public static volatile SingularAttribute<Acesso, String> email;
    public static volatile SingularAttribute<Acesso, Doador> doador;

}