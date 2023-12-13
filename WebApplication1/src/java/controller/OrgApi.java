/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Organizacao;
import model.RocketDAO;

/**
 *
 
@author erick*/
@WebServlet(name = "OrgApi", urlPatterns = {"/OrgApi"})
public class OrgApi extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Organizacao> listaOrg = new RocketDAO().listOrg();

        // Criar uma lista de objetos JSON para as organizações
        List<JsonObject> jsonOrgList = new ArrayList<>();

        for (Organizacao org : listaOrg) {
            JsonObject orgJson = new JsonObject();

            // Configurar os atributos do objeto JSON para cada organização
            orgJson.addProperty("id", org.getUsuarioEmail());
            orgJson.addProperty("nome", org.getDoador().getNome());
            orgJson.addProperty("missao", org.getMissao());
            orgJson.addProperty("img", org.getDoador().getImagemUrl());

            jsonOrgList.add(orgJson);
        }

        // Converter a lista de objetos JSON em uma string JSON
        Gson gson = new Gson();
        String json = gson.toJson(jsonOrgList);

        // Configurar a resposta HTTP
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
        response.setStatus(HttpServletResponse.SC_OK);
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

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    

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
