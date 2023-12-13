<%-- 
  Document  : editarDoador
  Created on : 12 de dez. de 2023, 02:30:52
  Author   : erick
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/editarDoador.css"/>

    </head>
    <body>

        <%@ include file="menuLogado.jsp" %>

        <div class="form-container">
            <form method="POST" action="controle">
                <input type="hidden" name="flag" value="alterarFuncionario">
                <input type="hidden" name="email" value="${doador.email}">
                <input type="hidden" name="idEndereco" value="${endereco.idendereco}">

                <h2>Acesso</h2>
                <label for="senha">Senha</label>
                <input type="password" name="senha" id="senha" value="${doador.acesso.senha} placeholder="Senha"><br>
                <label for="senha2">Confirme a Senha</label>
                <input type="password" name="senha2" id="senha2" placeholder="Confirme a Senha"><br>

                <h2>Doador</h2>
                <label for="nome">Nome</label>
                <input type="text" name="nome" id="nome" placeholder="Nome" value="${doador.nome}"><br>
                <label for="telefone">Telefone</label>
                <input type="text" name="telefone" id="telefone" placeholder="Telefone" value="${doador.telefone}" ><br>

                <label for="url">Imagem</label>
                <input type="text" name="url" id="url" value="${doador.imagemUrl}" ><br>

                <h2>Endereço</h2>
                <label for="rua">Rua</label>
                <input type="text" name="rua" id="rua" placeholder="Rua" value="${endereco.rua}"><br>
                <label for="numero">Número</label>
                <input type="number" name="numero" id="numero" placeholder="Número" value="${endereco.numero}"><br>
                <label for="cep">CEP</label>
                <input type="text" name="cep" id="cep" placeholder="CEP" value="${endereco.cep}"><br>
                <label for="complemento">Complemento</label>
                <input type="text" name="complemento" id="complemento" placeholder="Complemento" value="${endereco.complemento}"><br>
                <input type="submit" value="Editar">
            </form>
        </div>

    </body>
</html>