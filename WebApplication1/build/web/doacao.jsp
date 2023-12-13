<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Tela Doação</title>
    <link rel="stylesheet" href="css/doacao.css">
</head>
<body>
     <header >
        <%@ include file="menuu.jsp"%>
        </header>
    <div class="doacao">
        <div id="content-container">
            <h1>Chave Pix</h1>
            <div id="qrcode-container">
                <div id="qrcode"></div>
                <button id="generateButton">Gerar Novo</button>
            </div>
        </div>
    </div>
    <script src="https://cdn.rawgit.com/davidshimjs/qrcodejs/gh-pages/qrcode.min.js"></script>
    <script src="js/doacao.js"></script>
</body>
</html>