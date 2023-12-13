package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Organizacao;

@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2023-12-12T23:07:29")
@StaticMetamodel(ContaBancaria.class)
public class ContaBancaria_ { 

    public static volatile SingularAttribute<ContaBancaria, String> agenciaConta;
    public static volatile SingularAttribute<ContaBancaria, String> chavePix;
    public static volatile SingularAttribute<ContaBancaria, Organizacao> fkEmail;
    public static volatile SingularAttribute<ContaBancaria, String> numeroConta;
    public static volatile SingularAttribute<ContaBancaria, Integer> idCc;
    public static volatile SingularAttribute<ContaBancaria, String> codBanco;

}