/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;


import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
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
    public boolean verificarCadastroDoador(Doador doador, String email) {
        connect();
        try {
            Query q = manager.createNamedQuery("Doador.findByEmail", Doador.class);
            q.setParameter("email", email);
            List<Doador> resultados = q.getResultList();
            if(!resultados.isEmpty()){
                return false;
            }
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
    
    //Metodo para validar o login, tanto de daodor quanto de otganizacao;
    public Acesso validarLogin(String u, String s) {
        connect();
        try {
            TypedQuery<Acesso> q = manager.createNamedQuery("Acesso.findByEmailSenha", Acesso.class);//Query tirado da classe "Acesso",query para pegar usuario e senha;
            q.setParameter("email", u);
            q.setParameter("senha", s);
            Acesso acesso = q.getSingleResult();
            return acesso;
        } catch (NoResultException ex) {
            return null;
        }
    }
    
    //Metodo para cadastrar na tabela Organizacao;
    public void cadastroOrg(Organizacao org) {
        connect();
        try {
            manager.getTransaction().begin();
            manager.persist(org);
            manager.getTransaction().commit();
        } catch (NoResultException e) {
        }
    }
    //Metodo para verificar se o cadastro de Organizacao funcionaria;
    public boolean verificarCadastroOrg(Organizacao org){
        connect();
        try {
            manager.getTransaction().begin();
            manager.persist(org);
            // Não comita a transação, apenas verifica se a persistência seria bem-sucedida
            manager.getTransaction().rollback();
            return true;
        } catch (Exception e) {
            // Pode ser mais específico no tipo de exceção, dependendo da implementação do JPA
            return false;
        }
    }
    
    //Metodo para cadastrar na tabela ContaBancaria;
    public void cadastroContaBancaria(ContaBancaria bancario) {
        connect();
        try {
            manager.getTransaction().begin();
            manager.persist(bancario);
            manager.getTransaction().commit();
        } catch (NoResultException e) {
        }
    }
    //Metodo para verificar se o cadastro de Contabancaria funcionaria;
    public boolean verificarCadastroBanco(ContaBancaria bancario){
        connect();
        try {
            manager.getTransaction().begin();
            manager.persist(bancario);
            // Não comita a transação, apenas verifica se a persistência seria bem-sucedida
            manager.getTransaction().rollback();
            return true;
        } catch (Exception e) {
            // Pode ser mais específico no tipo de exceção, dependendo da implementação do JPA
            return false;
        }
    }
    
    public List<Organizacao> listOrg() {
        connect();
        try {

            TypedQuery<Organizacao> query = manager.createNamedQuery("Organizacao.findAll", Organizacao.class);
            List<Organizacao> lista = query.getResultList();
            return lista;
        } catch (NoResultException ex) {
            return null;
        }
    }
    
    public Doador obterDoadorPorEmail(String email){
        connect();
        try{
            TypedQuery<Doador> q = manager.createNamedQuery("Doador.findByEmail", Doador.class);
            q.setParameter("email", email);
            return q.getSingleResult();
        }catch (NoResultException ex){
            return null;
        }
    }
    
    public Endereco obterEnderecoPorEmail(String email){
        connect();
        try{
            TypedQuery<Endereco> q = manager.createQuery("SELECT e FROM Endereco e WHERE e.fkEmail.email = :email", Endereco.class);
            q.setParameter("email", email);
            return q.getSingleResult();
        }catch (NoResultException ex) {
            return null;
        }
    } 
    
    public ContaBancaria obterContaBancariaPorEmail(String email){
        connect();
        try{
            TypedQuery<ContaBancaria> q = manager.createQuery("SELECT c FROM ContaBancaria c WHERE c.fkEmail.usuarioEmail = :email", ContaBancaria.class);
            q.setParameter("email", email);
            return q.getSingleResult();
        }catch (NoResultException ex) {
            return null;
        }
    } 
    
    public List<Doacao> listarDoacoesPorEmailOrganizacao(String emailOrganizacaoParametro) {
        connect();
        try {
            TypedQuery<Doacao> q = manager.createQuery("SELECT d FROM Doacao d WHERE d.organizacaoUsuarioEmail.email = :email", Doacao.class);
            q.setParameter("email", emailOrganizacaoParametro);
            return q.getResultList();
        } catch (NoResultException ex) {
            return null;
        }
    }
    
    public boolean alterarOrganizacao (int pkEndere, int pkCB, String pkDoa,String senha, String senhaV, String nomeOrg, String site, String categoria, String telefone, String agenciaConta, String cep, String numeroConta, String rua, String chavePix, String numero, String codBanco, String missao, String complemento, String urlLocal, String urlPerfil){
        connect();
        try{
            
            Doador doa = manager.find(Doador.class, pkDoa);
            Endereco end = manager.find(Endereco.class, pkEndere);
            ContaBancaria cb = manager.find(ContaBancaria.class, pkCB);
            
            doa.setNome(nomeOrg);
            doa.setTelefone(telefone);
            doa.setImagemUrl(urlPerfil);
            
            doa.getAcesso().setSenha(senha);
            
            doa.getOrganizacao().setCategoria(categoria);
            doa.getOrganizacao().setMissao(missao);
            doa.getOrganizacao().setSite(site);
            doa.getOrganizacao().setLocalImagem(urlLocal);
            doa.getOrganizacao().setMissao(missao);
            
            
            end.setCep(cep);
            end.setComplemento(complemento);
            end.setNumero(Integer.parseInt(numero));
            end.setRua(rua);
            
            cb.setAgenciaConta(agenciaConta);
            cb.setChavePix(chavePix);
            cb.setCodBanco(codBanco);
            cb.setNumeroConta(numeroConta);
            
            manager.getTransaction().begin();
            manager.merge(doa);//So aceita tipos Object;
            manager.getTransaction().commit();
            
            manager.getTransaction().begin();
            manager.merge(end);//So aceita tipos Object;
            manager.getTransaction().commit();
            
            manager.getTransaction().begin();
            manager.merge(cb);//So aceita tipos Object;
            manager.getTransaction().commit();
            
            
            return true;
        }catch (NoResultException e){
            return false;
        }
    }
    
    public boolean alterarDoador(Doador doador, Endereco endereco) {
        connect();
        try {

            Doador doadorUpdate = manager.find(Doador.class, doador.getEmail());
            Endereco enderecoUpdate = manager.find(Endereco.class, endereco.getIdendereco());

            doadorUpdate.setNome(doador.getNome());
            doadorUpdate.setTelefone(doador.getTelefone());
            doadorUpdate.setImagemUrl(doador.getImagemUrl());

            enderecoUpdate.setRua(endereco.getRua());
            enderecoUpdate.setNumero(endereco.getNumero());
            enderecoUpdate.setCep(endereco.getCep());
            enderecoUpdate.setComplemento(endereco.getComplemento());

            manager.getTransaction().begin();
            manager.merge(doadorUpdate);//So aceita tipos Object;
            manager.getTransaction().commit();

            manager.getTransaction().begin();
            manager.merge(enderecoUpdate);//So aceita tipos Object;
            manager.getTransaction().commit();

            return true;
        } catch (NoResultException e) {
            return false;
        }
    }

    public boolean alterarSenha(Acesso acesso, String email) {
        connect();
        try {

            Acesso acessoUpdate = manager.find(Acesso.class, email);

            acessoUpdate.setSenha(acesso.getSenha());

            manager.getTransaction().begin();
            manager.merge(acessoUpdate);
            // Não comita a transação, apenas verifica se a persistência seria bem-sucedida
            manager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            // Pode ser mais específico no tipo de exceção, dependendo da implementação do JPA
            throw new  NullPointerException("");
        }
    }
    
     public List<Noticia> listarNoticia() {
        try {
            connect();
            TypedQuery<Noticia> query = manager.createNamedQuery("Noticia.findAll", Noticia.class);

            List<Noticia> list = query.getResultList().
                    stream().sorted(Comparator.comparing(Noticia::getData).reversed())
                    .collect(Collectors.toList());

            return list;
        } catch (NullPointerException ex) {
            return null;
        }
    }

    public List<Noticia> findNoticiasByEmailOrganizacao(String email) {
        try {
            TypedQuery<Noticia> query = manager.createNamedQuery("Noticia.findByEmailOrganizacao", Noticia.class);
            query.setParameter("email", email);
            return query.getResultList();
        } catch (Exception e) {
            return null;
        }
    }
    
    public Organizacao obterOrganizacaoPorEmail(String email){
        connect();
        try{
            TypedQuery<Organizacao> q = manager.createQuery("SELECT o FROM Organizacao o WHERE o.usuarioEmail = :email", Organizacao.class);
            q.setParameter("email", email);
            return q.getSingleResult();
        }catch (NoResultException ex) {
            return null;
        }
    }
    
    
    public boolean verificarCadastroNoticia(Noticia noticia){
        connect();
        try {
            manager.getTransaction().begin();
            manager.persist(noticia);
            // Não comita a transação, apenas verifica se a persistência seria bem-sucedida
            manager.getTransaction().rollback();
            return true;
        } catch (Exception e) {
            // Pode ser mais específico no tipo de exceção, dependendo da implementação do JPA
            return false;
        }
    }
    
    public boolean cadastroNoticia(Noticia noticia){
        connect();
        try {
            manager.getTransaction().begin();
            manager.persist(noticia);
            manager.getTransaction().commit();
            return true;
        } catch (NoResultException e) {
            // Pode ser mais específico no tipo de exceção, dependendo da implementação do JPA
            return false;
        }
    }
    

    public Noticia noticiaFindId(Integer id) {
        try {
            connect();
            Noticia noticia = manager.find(Noticia.class, id);
            return noticia;
        } catch (NoResultException e) {
            return null; // Retorna null se não encontrar a notícia com o ID fornecido
        }
    }
    
    public boolean verificarCadastroDoacao(Doacao doacao){
        connect();
        try {
            manager.getTransaction().begin();
            manager.persist(doacao);
            // Não comita a transação, apenas verifica se a persistência seria bem-sucedida
            manager.getTransaction().rollback();
            return true;
        } catch (Exception e) {
            // Pode ser mais específico no tipo de exceção, dependendo da implementação do JPA
            return false;
        }
    }
    
    public void cadastroDoacao(Doacao doacao) {
        connect();
        try {
            manager.getTransaction().begin();
            manager.persist(doacao);
            manager.getTransaction().commit();
        } catch (NoResultException e) {
        }
    }
    
    
    
}
