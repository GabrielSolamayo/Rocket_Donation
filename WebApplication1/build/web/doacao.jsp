
<%@page import="model.Organizacao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="pt_br">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link href="https://cdn.jsdelivr.net/npm/remixicon@3.2.0/fonts/remixicon.css" rel="stylesheet">
  <script src="doacao.js"></script>
  <title>Doacao</title>
  <link rel="stylesheet" href="./css/doacao.css">
</head>

<body>
    <%
        String emailOrg = (String)request.getAttribute("emailOrg");
        // Agora você pode usar a variável pkOrga conforme necessário na sua página JSP
    %>

        <header style="padding-top: 100px">
            <%@ include file="menuu.jsp" %>
        </header>

  <div class="content">

    <div id="sla">
      <h1>Obrigado pela doacao !!</h1>
      <section class="doacao">
        <h2>Qualquer quantia ja faz a diferenca ;p</h2>
    </div>
    <div id="outraDiv">
      <!-- ... (seu cï¿½digo existente) ... -->
      <section class="valorDoacao">
        <h2>Valor da doacao</h2>
        <input type="number" id="valorDoacao" name="valorDoacao" placeholder="R$ 0,00">
        <input type="hidden" name="pkOrg" value="${emailOrg}">
        <a href="controle?flag=doacaoSemLog"><button class="botao-doar" type="submit">Doar <i class="ri-heart-add-line"></i></button></a>
      </section>

      <img
        src="https://www.gov.br/inss/pt-br/centrais-de-conteudo/imagens/qr-code-novo-fw-300x300-png/@@images/image.png"
        alt="QR">

    </div>
  </div>
</body>
</html>