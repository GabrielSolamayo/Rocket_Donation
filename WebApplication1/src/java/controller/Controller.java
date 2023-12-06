/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Acesso;
import model.Doador;
import model.Endereco;
import model.RocketDAO;

/**
 *
 * @author solam
 */
@WebServlet(name = "Controller", urlPatterns = {"/Controller"})
public class Controller extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String flag, mensagem = "";
        
        RocketDAO dao = new RocketDAO(); //Importa a classe RocketDAO para utilizarmos as funções daquela classe;
        flag = request.getParameter("flag");
        HttpSession session = null;
        
        if(flag.equalsIgnoreCase("cadastrar")){
            
            Doador doador = new Doador();
            Endereco endereco = new Endereco();

            doador.setNome(request.getParameter("nome"));
            doador.setEmail(request.getParameter("email"));
            doador.setTelefone(request.getParameter("telefone"));
            doador.setUserType("Doador");
            boolean resp = dao.verificarCadastroDoador(doador);
            if(resp){ //Se o doador for cadastrado com sucesso;
                Acesso acesso = new Acesso();
                acesso.setEmail(doador.getEmail());
                acesso.setSenha(request.getParameter("senha"));
                resp = dao.verificarCadastroAcesso(acesso);
                if(resp){ //Se o acesso for cadastrado com sucesso;
                    int num = Integer.parseInt(request.getParameter("numero"));//Convertendo para int o 'text' do formulario;
                    endereco.setCep(request.getParameter("cep"));
                    endereco.setNumero(num);
                    endereco.setRua(request.getParameter("endereco"));
                    endereco.setComplemento(request.getParameter("complemento"));
                    endereco.setFkEmail(doador);
                    resp = dao.verificarCadastroEndereco(endereco);
                    if(resp){
                        dao.cadastroDoador(doador);
                        dao.cadastroAcesso(acesso);
                        dao.cadastroEndereco(endereco);
                    }else{
                        mensagem = "Endereco nao efetutado";
                    }
                }else{
                    mensagem = "Acesso nao efetuado";
                }
            }else {
                mensagem = "Cadastro Doador nao efetuado.";
            }
            
            
            
            
            
            if(resp){
                mensagem = "Cadastro de Endereco feito com sucesso";
            }
            request.setAttribute("m", mensagem);
            RequestDispatcher disp = request.getRequestDispatcher("index.html");
            disp.forward(request, response);
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
        processRequest(request, response);
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
        processRequest(request, response);
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
