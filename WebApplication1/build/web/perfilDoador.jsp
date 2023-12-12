<%-- 
    Document   : perfilDoador
    Created on : 9 de dez. de 2023, 15:36:39
    Author     : solam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="https://cdn.jsdelivr.net/npm/remixicon@3.2.0/fonts/remixicon.css" rel="stylesheet">
        <link rel="stylesheet" href="css/perfilDoador.css">
        <title>Document</title>
    </head>
    <body>
        <header >
            <%@ include file="menuLogado.jsp"%>
        </header>
        <div class="background">
            <div class="container-perfil-doador">
                <div class="perfil">
                    <h1>Nome</h1>

                    <div class="perfil-info">
                        <img src="pictures/solidariedade.png" alt="Imagem de Perfil">
                        <p></p>
                        <button class="editar-btn"><a href="historico.jsp"><i class="ri-edit-line"></i>Historico</a></button>
                        <p></p>
                    </div>
                </div>
                <div class="divider-red">
                </div>
                <div class="doador">
                    <h1><i class="ri-mental-health-line"></i> Bem-vindo ao seu perfil doador!</h1>
                    <div class="doador-info">
                        <div class="doador-item">
                            <h2><i class="ri-file-edit-fill"></i>Meus dados<i class="ri-arrow-down-line"></i></h2>
                            <p>Nome: ${doador.nome}</p>
                            <p>Email: ${doador.email}</p>
                            <p>Telefone: ${doador.telefone} </p>
                            <p>Endereço: ${endereco.rua},  n° ${endereco.numero} </p>
                            <p>Cep: ${endereco.cep}</p>
                            <button class="editar-btn"><a href="controle?flag=editarDoador&email=${doador.email}"><i class="ri-edit-line"></i>Editar</a></button>
                        </div>
                    </div>
                </div>
            </div><!--Background-->
    </body>
</html>
