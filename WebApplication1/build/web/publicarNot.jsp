
<%@page import="model.Organizacao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./css/publicarNot.css">
    <link href="https://cdn.jsdelivr.net/npm/remixicon@3.2.0/fonts/remixicon.css" rel="stylesheet">
    <title>Formulario de Noticias</title>
</head>
        <header style="padding-top: 100px">
            <%@ include file="menuLogado.jsp" %>
        </header>
<body>
    <div class="background">
        <div class="elements">
    <div class="info-container">
        <div class="info-message">
            <p>Publique noticias sobre as doacoes recebidas para compartilhar com a comunidade!</p>
            <p>Lembre-se de fornecer informacoes claras e agradecimentos aos doadores.</p>
           
        </div>
    </div>
    <div class="container-public">
        <form method="POST" action="controle">
            <input type="hidden" name="flag" value="postNoticia">
            <input type="hidden" name="pkOrg" value="${organizacao.emailUsuario}">
            <h2><i class="ri-draft-fill"></i>Publicar Noticia</h2>
            
            <label for="titulo">Titulo:</label>
            <input type="text" id="titulo" name="titulo" required>

            <label for="conteudo">Conteudo:</label>
            <textarea id="conteudo" name="conteudo" rows="4" required></textarea>

            <label for="imagem">Imagem (URL):</label>
            <input type="url" id="imagem" name="imagem">

            <button type="submit">Publicar</button>
            <!-- Apï¿½s o botï¿½o de envio -->
        </form>
    </div>
</div><!--elementes-->
</div><!--Background-->
</body>
</html>
