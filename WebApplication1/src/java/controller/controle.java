/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import com.sun.org.apache.bcel.internal.generic.AALOAD;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
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
import model.Doacao;
import model.Doador;
import model.Endereco;
import model.Noticia;
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
            doador.setImagemUrl(request.getParameter("urlFotoPerfil"));
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
                            session.setAttribute("endereco", endereco);
                            request.setCharacterEncoding("UTF-8");
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
                Endereco endereco = dao.obterEnderecoPorEmail(email);
                session = request.getSession();
                session.setAttribute("emailUsuario", email);
                session.setAttribute("nomeUsuario", nome);
                session.setAttribute("typeUsuario", type);
                session.setAttribute("endereco", endereco);
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
            doadOR.setImagemUrl(request.getParameter("urlFotoPerfil"));
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
                            org.setLocalImagem(request.getParameter("urlFotoLocal"));
                            org.setDescOrg(request.getParameter("descOrg"));
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
                                    session.setAttribute("endereco", endereco);
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
            
            
        } else if(flag.equalsIgnoreCase("perfilLogado")){
            String emailUsuario = request.getParameter("email");
            Doador doa = dao.obterDoadorPorEmail(emailUsuario);
            
            request.setAttribute("doador", doa);
            if(doa.getUserType().equalsIgnoreCase("Doador")){
                
                RequestDispatcher disp = request.getRequestDispatcher("perfilDoador.jsp");
                disp.forward(request, response);
                
            }else if(doa.getUserType().equalsIgnoreCase("Instituicao")){
                
                 RequestDispatcher disp = request.getRequestDispatcher("perfilLogado.jsp");

                List<Noticia> listaNoticia = dao.findNoticiasByEmailOrganizacao(emailUsuario);

                request.setAttribute("listaNoticia", listaNoticia);
                disp.forward(request, response);
            }  
            
        } else if(flag.equalsIgnoreCase("historico")){ 
            String emailUsuario = request.getParameter("email");
            Doador doador = dao.obterDoadorPorEmail(emailUsuario);
            if(doador.getUserType().equalsIgnoreCase("Instituicao")){
                List<Doacao> listarDoacaoOrg = dao.listarDoacoesPorEmailOrganizacao(emailUsuario);
                request.setAttribute("listarDoacao", listarDoacaoOrg);
                request.setAttribute("doador", doador);
                RequestDispatcher disp = request.getRequestDispatcher("historico.jsp");
                disp.forward(request, response);
            }
            
        } else if(flag.equalsIgnoreCase("editarPerfilOrg")){
            String email = request.getParameter("email");
            Doador doador = dao.obterDoadorPorEmail(email);
            Endereco endereco = dao.obterEnderecoPorEmail(email);
            ContaBancaria bancario = dao.obterContaBancariaPorEmail(email);
            
            
            request.setAttribute("doador", doador);
            request.setAttribute("endereco", endereco);
            request.setAttribute("bancario", bancario);
            
            
            RequestDispatcher disp = request.getRequestDispatcher("editarPerfilOrg.jsp");
            disp.forward(request, response);
            
            
        } else if(flag.equalsIgnoreCase("alterarOrg")){
            String senha, senhaV, pkDoa, nomeOrg, site, categoria, telefone, agenciaConta, cep, numeroConta, rua, chavePix, numero, codBanco, missao, complemento, urlLocal, urlPerfil;
            int pkEnd, pkBan;
            
            senha = request.getParameter("senha");
            senhaV = request.getParameter("confirmarSenha");
            pkDoa = request.getParameter("pkDoador");
            pkEnd = Integer.parseInt(request.getParameter("pkEndereco"));
            pkBan = Integer.parseInt(request.getParameter("pkContaBancaria"));
            
            nomeOrg = request.getParameter("nomeOrg");
            site = request.getParameter("site");
            categoria = request.getParameter("categoria");
            telefone = request.getParameter("telefone");
            agenciaConta = request.getParameter("agenciaConta");
            cep = request.getParameter("cep");
            numeroConta = request.getParameter("numeroConta");
            rua = request.getParameter("rua");
            chavePix = request.getParameter("chavePix");
            numero = request.getParameter("numero");
            codBanco = request.getParameter("codBanco");
            missao = request.getParameter("missao");
            complemento = request.getParameter("complemento");
            urlLocal = request.getParameter("urlFotoLocal");
            urlPerfil = request.getParameter("urlFotoPerfil");
            
            boolean resp = dao.alterarOrganizacao(pkEnd, pkBan, pkDoa, senha, senhaV, nomeOrg, site, categoria, telefone, agenciaConta, cep, numeroConta, rua, chavePix, numero, codBanco, missao, complemento, urlLocal, urlPerfil);
            
            if(resp){
                
                mensagem = "Alteração feito com sucesso!";
                request.setAttribute("m", mensagem);
                RequestDispatcher disp = request.getRequestDispatcher("perfilLogado.jsp");
                disp.forward(request, response);
            }
            
            
            
            
        } else if (flag.equalsIgnoreCase("editarDoador")) {

            String email = request.getParameter("email");
            Doador doador = dao.obterDoadorPorEmail(email);
            Endereco endereco = dao.obterEnderecoPorEmail(email);

            request.setAttribute("doador", doador);
            request.setAttribute("endereco", endereco);

            RequestDispatcher disp = request.getRequestDispatcher("editarDoador.jsp");
            disp.forward(request, response);
        } else if (flag.equalsIgnoreCase("alterarFuncionario")) {

            String email = request.getParameter("email");
            Integer id = Integer.valueOf(request.getParameter("idEndereco"));

            response.getWriter().print(id);
            response.getWriter().print(email);

            String nome = request.getParameter("nome");
            String telefone = request.getParameter("telefone");

            Doador doador = new Doador(email, request.getParameter("nome"), request.getParameter("telefone"));
            doador.setImagemUrl(request.getParameter("url"));
            String rua = request.getParameter("rua");
            Integer numero = Integer.valueOf(request.getParameter("numero"));
            String cep = request.getParameter("cep");
            String complemento = request.getParameter("complemento");

            Endereco endereco = new Endereco(id, request.getParameter("rua"), Integer.valueOf(request.getParameter("numero")),
                    request.getParameter("cep"), request.getParameter("complemento"));

            dao.alterarDoador(doador, endereco);

            String senha = request.getParameter("senha");
            String senhaV = request.getParameter("senha2");

            if (senha.equals(senhaV) && senha != null) {
                Acesso acesso = new Acesso(doador.getEmail(), senha);
                dao.alterarSenha(acesso, email);
            }

            request.setAttribute("doador", doador);
            request.setAttribute("endereco", endereco);

            RequestDispatcher disp = request.getRequestDispatcher("perfilDoador.jsp");
            disp.forward(request, response);
            
        } else if(flag.equalsIgnoreCase("publicarNot")){
            
            String pkOrg = request.getParameter("email");
            request.setAttribute("pkOrga", pkOrg);
            RequestDispatcher disp = request.getRequestDispatcher("publicarNot.jsp");
            disp.forward(request, response);
        
        } else if(flag.equalsIgnoreCase("postNoticia")){
            String pkOrg = request.getParameter("pkOrg");
            Organizacao org = dao.obterOrganizacaoPorEmail(pkOrg);
            
            Noticia noticia = new Noticia();
            
            Date dataAtual = new Date();
                SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                String dataFormatada = formato.format(dataAtual);
                Date dataConvertida = formato.parse(dataFormatada);
            noticia.setData(dataConvertida);
            noticia.setDescricao(request.getParameter("conteudo"));
            noticia.setImgUrl(request.getParameter("imagem"));
            noticia.setTitulo(request.getParameter("titulo"));
            noticia.setFkEmail(org);
            
            boolean resp = dao.verificarCadastroNoticia(noticia);
            if(resp){
                dao.cadastroNoticia(noticia);
                mensagem = "Noticia publicada com sucesso! Obrigado por compartilhar.";
                request.setAttribute("m", mensagem);
                RequestDispatcher disp = request.getRequestDispatcher("publicarNotSUCESSO.jsp");
                disp.forward(request, response);
            }
            
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
