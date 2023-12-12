<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./css/publicarNot.css">
    <link href="https://cdn.jsdelivr.net/npm/remixicon@3.2.0/fonts/remixicon.css" rel="stylesheet">
    <title>Formul�rio de Not�cias</title>
</head>
 <header >
        <%@ include file="menuu.jsp"%>
        </header>
<body>
    <div class="background">
        <div class="elements">
    <div class="info-container">
        <div class="info-message">
            <p>Publique not�cias sobre as doa��es recebidas para compartilhar com a comunidade!</p>
            <p>Lembre-se de fornecer informa��es claras e agradecimentos aos doadores.</p>
            <button ><a href=""></a>Voltar ao Perfil</button>
           
        </div>
    </div>
    <div class="container-public">
        <form action="processar_noticia.php" method="post">
            <h2><i class="ri-draft-fill"></i>Publicar Not�cia</h2>
            
            <label for="titulo">T�tulo:</label>
            <input type="text" id="titulo" name="titulo" required>

            <label for="conteudo">Conte�do:</label>
            <textarea id="conteudo" name="conteudo" rows="4" required></textarea>

            <label for="imagem">Imagem (URL):</label>
            <input type="url" id="imagem" name="imagem">

            <button type="submit">Publicar</button>
            <!-- Ap�s o bot�o de envio -->

<div class="submit-message" id="submitMessage">
    <!-- A mensagem de confirma��o ou erro ser� exibida aqui -->
</div>
        </form>
    </div>
</div><!--elementes-->
</div><!--Background-->
<script src="./scripts/pubulicarNot.js"></script>
</body>
</html>
