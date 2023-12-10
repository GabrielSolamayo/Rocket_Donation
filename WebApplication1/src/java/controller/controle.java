/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Acesso;
import model.ContaBancaria;
import model.Doador;
import model.Endereco;
import model.Organizacao;
import model.RocketDAO;

/**
 *
 * @author solam
 */
@WebServlet(name = "controle", urlPatterns = {"/controle"})
public class controle extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
        response.setContentType("text/html;charset=UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String flag, mensagem = "";

        RocketDAO dao = new RocketDAO(); //Importa a classe RocketDAO para utilizarmos as funções daquela classe;
        flag = request.getParameter("flag");
        HttpSession session = null;

        if(flag.equalsIgnoreCase("cadastroDoador")) {//IF PARA O CADASTRO DO DOADOR;
            String senha, senhaV;
            Doador doador = new Doador();
            Endereco endereco = new Endereco();

            doador.setNome(request.getParameter("nome"));
            doador.setEmail(request.getParameter("email"));
            doador.setTelefone(request.getParameter("telefone"));
            doador.setUserType("Doador");
            senha = request.getParameter("senha");
            senhaV = request.getParameter("confirmarSenha");
            if (senha.equals(senhaV)) { //Verifica se as senhas sao iguais ou nao;
                boolean resp = dao.verificarCadastroDoador(doador, doador.getEmail());
                if (resp) { //Se o doador for cadastrado com sucesso;
                    Acesso acesso = new Acesso();
                    acesso.setEmail(doador.getEmail());
                    acesso.setSenha(request.getParameter("senha"));
                    acesso.setDoador(doador);
                    resp = dao.verificarCadastroAcesso(acesso);
                    if (resp) { //Se o acesso for cadastrado com sucesso;
                        int num = Integer.parseInt(request.getParameter("numero"));//Convertendo para int o 'text' do formulario;
                        endereco.setCep(request.getParameter("cep"));
                        endereco.setNumero(num);
                        endereco.setRua(request.getParameter("endereco"));
                        endereco.setComplemento(request.getParameter("complemento"));
                        endereco.setFkEmail(doador);
                        resp = dao.verificarCadastroEndereco(endereco);
                        if (resp) {
                            String email, nome, type;
                            dao.cadastroDoador(doador);
                            dao.cadastroAcesso(acesso);
                            dao.cadastroEndereco(endereco);
                            email = acesso.getDoador().getEmail();
                            nome = acesso.getDoador().getNome();
                            type = acesso.getDoador().getUserType();
                            session = request.getSession();
                            session.setAttribute("emailUsuario", email);
                            session.setAttribute("nomeUsuario", nome);
                            session.setAttribute("typeUsuario", type);
                            RequestDispatcher disp = request.getRequestDispatcher("indexLogado.jsp");
                            disp.forward(request, response);
                        } else {
                            mensagem = "Endereco nao efetutado";
                        }
                    } else {
                        mensagem = "Acesso nao efetuado";
                    }
                } else {
                    mensagem = "Email ja registrado";
                    request.setAttribute("m", mensagem);
                    RequestDispatcher disp = request.getRequestDispatcher("cadastroDoaERRO.jsp");
                    disp.forward(request, response);
                }
            }else {
                mensagem = "Senha estão diferentes";
                request.setAttribute("m", mensagem);
                RequestDispatcher disp = request.getRequestDispatcher("cadastroDoaERRO.jsp");
                disp.forward(request, response);
            }


        }else if(flag.equalsIgnoreCase("login")) {// IF PARA O LOGIN DO DOADOR OU ORGANIZACAO;
            String user, password;
            user = request.getParameter("email");
            password = request.getParameter("senha");
            Acesso acesso = dao.validarLogin(user, password);
            if (acesso == null) {
                request.setAttribute("m", "Login não existe");
                RequestDispatcher disp = request.getRequestDispatcher("loginERRO.jsp");
                disp.forward(request, response);
            } else {
                String nome, email, type;
                nome = acesso.getDoador().getNome();
                email = acesso.getDoador().getEmail();
                type = acesso.getDoador().getUserType();
                session = request.getSession();
                session.setAttribute("emailUsuario", email);
                session.setAttribute("nomeUsuario", nome);
                session.setAttribute("typeUsuario", type);
                RequestDispatcher disp = request.getRequestDispatcher("indexLogado.jsp");
                disp.forward(request, response);
            }
        } else if(flag.equalsIgnoreCase("cadastroOrg")){ //IF PARA CADASTRO DE ORGANIZAÇÃO
            String senha, senhaV;
            Doador doadOR = new Doador();
            Acesso acesso = new Acesso();
            Organizacao org = new Organizacao();
            Endereco endereco = new Endereco();
            ContaBancaria bancario = new ContaBancaria();
            
            doadOR.setEmail(request.getParameter("emailOrg"));
            doadOR.setNome(request.getParameter("nomeOrg"));
            doadOR.setTelefone(request.getParameter("telefone"));
            doadOR.setUserType("Instituicao");
            senha = request.getParameter("senha");
            senhaV = request.getParameter("confirmarSenha");
            if(senha.equals(senhaV)){//Verificar se as senhas sao iguais para prosseguir;
                boolean resp = dao.verificarCadastroDoador(doadOR, doadOR.getEmail()); //Utiliza o mesmo método de chegar doador para verificar o cadastro de Doador (user) e o email;
                if(resp){ //Verifica se o cadastro de doador (user) seria bem sucessido;
                    acesso.setEmail(doadOR.getEmail());
                    acesso.setSenha(request.getParameter("senha"));
                    acesso.setDoador(doadOR);
                    resp = dao.verificarCadastroAcesso(acesso);
                    if(resp){ //Verifica sei o cadastro de acesso seria bem sucessido;
                        endereco.setCep(request.getParameter("cep"));
                        endereco.setRua(request.getParameter("rua"));
                        endereco.setComplemento(request.getParameter("complemento"));
                        int num = Integer.parseInt(request.getParameter("numero"));
                        endereco.setNumero(num);
                        endereco.setFkEmail(doadOR);
                        resp = dao.verificarCadastroEndereco(endereco);
                        if(resp){ //Verifica se o cadastro de endereco seria bem sucessido;
                            org.setCategoria(request.getParameter("categoria"));
                            org.setMissao(request.getParameter("missao"));
                            org.setSite(request.getParameter("site"));
                                Date dataAtual = new Date();
                                SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                                String dataFormatada = formato.format(dataAtual);
                                Date dataConvertida = formato.parse(dataFormatada);
                            org.setDataCadastro(dataConvertida);
                            org.setUsuarioEmail(doadOR.getEmail());
                            resp = dao.verificarCadastroOrg(org);
                            if(resp){ //Verifica se o cadastro de organizacao seria bem sucessido;
                                bancario.setAgenciaConta(request.getParameter("agenciaConta"));
                                bancario.setChavePix(request.getParameter("chavePix"));
                                bancario.setNumeroConta(request.getParameter("numeroConta"));
                                bancario.setFkEmail(org);
                                bancario.setCodBanco(request.getParameter("codBanco"));
                                resp = dao.verificarCadastroBanco(bancario);
                                if(resp){ //Verifica se o cadastro de contaBancria seria bem sucessido
                                    String nome, email, type;
                                    
                                    dao.cadastroDoador(doadOR);
                                    dao.cadastroAcesso(acesso);
                                    dao.cadastroEndereco(endereco);
                                    dao.cadastroOrg(org);
                                    dao.cadastroContaBancaria(bancario);
                                    
                                    nome = acesso.getDoador().getNome();
                                    email = acesso.getDoador().getEmail();
                                    type = acesso.getDoador().getUserType();
                                    session = request.getSession();
                                    session.setAttribute("emailUsuario", email);
                                    session.setAttribute("nomeUsuario", nome);
                                    session.setAttribute("typeUsuario", type);
                                    RequestDispatcher disp = request.getRequestDispatcher("indexLogado.jsp");
                                    disp.forward(request, response);
                                }
                            }
                        } 
                    }
                }else{
                    mensagem = "Email já existe.";
                    request.setAttribute("m", mensagem);
                    RequestDispatcher disp = request.getRequestDispatcher("cadastroOrgERRO.jsp");
                    disp.forward(request, response);
                }
            }else {
                mensagem = "Senha estão diferentes.";
                request.setAttribute("m", mensagem);
                RequestDispatcher disp = request.getRequestDispatcher("cadastroOrgERRO.jsp");
                disp.forward(request, response);
            }
        } else if(flag.equalsIgnoreCase("logout")){ //usuario desejou sair da conta;
            session = request.getSession(false);
            if (session != null) {
                session.invalidate(); // Invalida a sessão existente
            }
            response.sendRedirect("index.jsp");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(controle.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(controle.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
