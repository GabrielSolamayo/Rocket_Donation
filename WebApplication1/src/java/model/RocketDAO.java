/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;


import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
/**
 *
 * @author solam
 */
public class RocketDAO {
    private EntityManagerFactory conn;
    private EntityManager manager;
    
    //Fazer a conexao como BD;
    public void connect() {
        conn = Persistence.createEntityManagerFactory("WebApplication1PU");//Nome tirado da pasta "Configuration Files", "pesistence.xml";
        manager = conn.createEntityManager();
    }
    
   //Metodo para cadastrar um doador, na tabela doador do BD, passando um object 'doador' como parametro;
    public void cadastroDoador(Doador doador) {
        connect();
        try {
            manager.getTransaction().begin();
            manager.persist(doador);
            manager.getTransaction().commit();
        } catch (NoResultException e) {
        }
    }
    //Metodo para verificar se cadastro de doador funcionaria;
    public boolean verificarCadastroDoador(Doador doador) {
    connect();
    try {
        manager.getTransaction().begin();
        manager.persist(doador);
        // Não comita a transação, apenas verifica se a persistência seria bem-sucedida
        manager.getTransaction().rollback();
        return true;
    } catch (Exception e) {
        // Pode ser mais específico no tipo de exceção, dependendo da implementação do JPA
        return false;
    }
}
    //Metodo para cadastrar um acesso, na tabela acesso do BD, passando um object 'acesso' como parametro;
    public void cadastroAcesso(Acesso acesso) {
        connect();
        try {
            manager.getTransaction().begin();
            manager.persist(acesso);
            manager.getTransaction().commit();
        } catch (NoResultException e) {
        }
    }
    //Metodo para verificar se cadastro de acesso funcionaria;
    public boolean verificarCadastroAcesso(Acesso acesso) {
    connect();
    try {
        manager.getTransaction().begin();
        manager.persist(acesso);
        // Não comita a transação, apenas verifica se a persistência seria bem-sucedida
        manager.getTransaction().rollback();
        return true;
    } catch (Exception e) {
        // Pode ser mais específico no tipo de exceção, dependendo da implementação do JPA
        return false;
    }
}
    
    //Metodo para cadastrar um endereco, na tabela endereco do BD, passando um object 'endereco' como parametro;
    public void cadastroEndereco(Endereco endereco) {
        connect();
        try {
            manager.getTransaction().begin();
            manager.persist(endereco);
            manager.getTransaction().commit();
        } catch (NoResultException e) {
        }
    }
    //Metodo para verificar se cadastro de endereco funcionaria;
    public boolean verificarCadastroEndereco(Endereco endereco) {
    connect();
    try {
        manager.getTransaction().begin();
        manager.persist(endereco);
        // Não comita a transação, apenas verifica se a persistência seria bem-sucedida
        manager.getTransaction().rollback();
        return true;
    } catch (Exception e) {
        // Pode ser mais específico no tipo de exceção, dependendo da implementação do JPA
        return false;
    }
}
}