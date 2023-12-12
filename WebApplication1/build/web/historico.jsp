<%@page import="java.util.List"%>
<%@page import="model.Doacao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="model.Doador" %>
<%@ page import="model.Endereco" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/remixicon@3.2.0/fonts/remixicon.css" rel="stylesheet">
    <link rel="stylesheet" href="css/historico.css">
    <title>Document</title>
</head>
<body>
     <header style="padding-top: 100px">
            <%@ include file="menuLogado.jsp" %>
     </header>
   <div class="background">
    <div class="container-historico">
        <div class="perfil">
            <h1>${doador.nome}</h1>

            <div class="perfil-info">
                <img src="pictures/solidariedade.png" alt="Imagem de Perfil">
                <p></p>
                <button class="editar-btn"><a href="#"><i class="ri-edit-line"></i>Editar Perfil</a></button>
                <p></p>
            </div>
        </div>
  <div class="divider-red">
  </div>
<div class="historico">
    <h1><i class="ri-edit-box-line"></i> Histórico de Doações</h1>
    <div class="historico-info">
        <%
            List<Doacao> listaDoacaoOrg = (List<Doacao>) request.getAttribute("listarDoacao");
        %>
        
        <% for(Doacao doacao: listaDoacaoOrg){ %>
        <div class="historico-item">
            <h2><%= doacao.getOrganizacaoUsuarioEmail() %></h2>
            <p><%= doacao.getDataDoacao()%></p>
            <p><%= doacao.getValor()%></p>
        </div>
        <% } %>
    </div>
</div>
</div><!--Background-->
</body>
</html>