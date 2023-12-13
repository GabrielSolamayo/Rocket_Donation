package controller;


import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Noticia;
import model.Organizacao;
import model.RocketDAO;

/**
 *
 * @author erick
 */
@WebServlet(name = "NoticiaApi", urlPatterns = {"/NoticiaApi"})
public class NoticiaApi2 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet NoticiaApi</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet NoticiaApi at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Date dataAtual = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        String dataFormatada = formato.format(dataAtual);
        
        List<Noticia> listaNoticias = new RocketDAO().listarNoticia();

        // Criar uma lista de objetos JSON para as organizações
        List<JsonObject> jsonOrgList = new ArrayList<>();
        
        for (Noticia noticia : listaNoticias) {
            JsonObject orgJson = new JsonObject();

            // Configurar os atributos do objeto JSON para cada organização
            orgJson.addProperty("id", noticia.getIdNoticia());
            orgJson.addProperty("imagem", noticia.getImgUrl());
            orgJson.addProperty("titulo", noticia.getTitulo());
            orgJson.addProperty("descricao", noticia.getDescricao());
            orgJson.addProperty("data", formato.format(noticia.getData()));
            
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
