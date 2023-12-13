<%@page import="model.Noticia"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Notícia</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                margin: 0;
                padding: 0;
            }
            .noticia-container {
                max-width: 600px;
                margin: 20px auto;
                padding: 20px;
                background-color: #f9f9f9;
                border-radius: 8px;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
                text-align: center; /* Para alinhar a imagem horizontalmente */
            }

            img {
                max-width: 70%;
                height: auto;
                display: block;
                border-radius: 8px;
                margin: 15px auto; /* Automaticamente centraliza horizontalmente */
            }
            h1 {
                font-size: 24px;
                margin-bottom: 10px;
            }
            p {
                font-size: 16px;
                line-height: 1.6;
                margin-bottom: 15px;
                text-align: justify;
            }
            .data {
                font-style: italic;
                color: #888;
            }
        </style>
    </head>
    <body>
        <div class="noticia-container">
            <img src="${noticia.imgUrl}" alt="Imagem da notícia">
            <h1>${noticia.titulo}</h1>
            <p>${noticia.descricao}</p>
            <p class="data">Data de publicação: ${noticia.data}</p>
        </div>
    </body>
</html>
