<%-- 
    Document   : editarPerfilOrg
    Created on : 11 de dez. de 2023, 17:51:30
    Author     : solam
--%>
<%@page import="model.Doador"%>
<%@page import="model.Endereco"%>
<%@page import="model.ContaBancaria"%>
<%@page import="model.Acesso"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Cadastro de Organização</title>
  <link rel="stylesheet" href="./css/AtualizacadastroOrg.css">
  <link href="https://cdn.jsdelivr.net/npm/remixicon@3.2.0/fonts/remixicon.css" rel="stylesheet">

</head>

<body>
  <header style="padding-top: 100px">
    
  </header>

  <div class="content">

    <div id="sla">
      <div>
        <h1>Atualize os Dados !! </h1>
      </div>
      <h1><i class="ri-home-heart-line"></i></h1>
      <h1>Mantenha suas informações atualizadas para uma experiência personalizada e segura.</h1>

        <span> Agradecemos por dedicar um momento para manter 
          sua conta sempre atualizada e personalizada.</span>
      
      <button id="login-cad"><a href="login.jsp">Voltar </a></button>
    </div>
    <div id="outraDiv">
      <!-- <h1>Cadastre-se</h1> -->
      <form id="cadastrar-form" method="POST" action="controle">
        <input type="hidden" name="flag" value="alterarOrg">
        <input type="hidden" name="pkDoador" value="${doador.email}">
        <input type="hidden" name="pkEndereco" value="${endereco.idendereco}">
        <input type="hidden" name="pkContaBancaria" value="${bancario.idCc}">
        <input type="hidden" name="pkAcesso" value="${doador.acesso.email}">
        <input type="hidden" name="pkOrganizacao" value="${doador.organizacao.usuarioEmail}">
        
        <div class="input-row">
          <label for="nomeOrg">Nome da Organização <i class="ri-home-heart-line"></i></label>
          <input type="text" id="nomeOrg" name="nomeOrg" value="${doador.nome}" >
        </div>
        <div class="input-row">
          <label for="site">Site <i class="ri-global-line"></i></label>
          <input type="text" id="site" name="site" value="${doador.organizacao.site}">
        </div>
        <div class="input-row">
          <label for="emailOrg">E-mail <i class="ri-mail-line"></i></label>
          <input type="email" id="emailOrg" name="emailOrg" value="${doador.email}">
        </div>
        <div class="input-row">
          <label for="categoria">Categoria da organização</label>
          <select id="categoria" name="categoria">
            <option value="${doador.organizacao.categoria}" disabled selected>${doador.organizacao.categoria}</option>
            <option value="cultura">Cultura</option>
            <option value="racismo">Racismo</option>
            <option value="meioAmbiente">Meio Ambiente</option>
            <option value="educacao">Educação</option>
            <option value="saude">Saúde</option>
            <!-- Adicione outras opcoes aqui -->
          </select>
        </div>
        <div class="input-row">
          <label for="senha">
            <p> Senha <i class="ri-lock-password-line"></i></p>
          </label>
          <input class="campo" type="password" id="senha" name="senha" value="${doador.acesso.senha}" >
        </div>
        <div class="input-row">
          <label for="telefone">Telefone <i class="ri-phone-line"></i></label>
          <input type="text" id="telefone" name="telefone" value="${doador.telefone}" >
        </div>
        <div class="input-row">
          <label for="confirmarSenha">
            <p> Confirme <i class="ri-pass-valid-line"></i></p>
          </label>
          <input class="campo" type="password" id="confirmarSenha" name="confirmarSenha"
           value="${doador.acesso.senha}" >
        </div>
        <div class="input-row">
          <label for="agenciaConta">Agência <i class="ri-bank-line"></i></label>
          <input type="text" id="agenciaConta" name="agenciaConta" value="${bancario.agenciaConta}" >
        </div>
        <div class="input-row">
          <label for="cep">CEP <i class="ri-map-pin-line"></i></label>
          <input type="text" id="cep" name="cep" value="${endereco.cep}" >
        </div>
        <div class="input-row">
          <label for="numeroConta">Conta Bancária <i class="ri-bank-line"></i></label>
          <input type="text" id="numeroConta" name="numeroConta" value="${bancario.numeroConta}" >
        </div>
        <div class="input-row">
          <label for="rua">Endereço <i class="ri-home-4-line"></i> </label>
          <input type="text" id="rua" name="rua" value="${endereco.rua}" >
        </div>
        <div class="input-row">
          <label for="chavePix">Chave PIX <i class="ri-qr-code-line"></i></label>
          <input type="text" id="chavePix" name="chavePix" value="${bancario.chavePix}" >
        </div>
        <div class="input-row">
          <label for="numero">Número <i class="ri-home-4-line"></i> </label>
          <input type="text" id="numero" name="numero" value="${endereco.numero}" >
        </div>
        <div class="input-row">
          <label for="numeroConta">Codigo do Banco <i class="ri-bank-line"></i></label>
          <input type="text" id="numeroConta" name="numeroConta" value="${bancario.codBanco}" >
        </div>
        <div class="input-row">
          <label for="missao">Missão da Organização <i class="ri-home-heart-line"></i></label>
          <textarea id="missao" name="missao">${doador.organizacao.missao}</textarea>
        </div>
        <div class="input-row">
          <label for="complemento">Complemento <i class="ri-home-4-line"></i> </label>
          <input type="text" id="complemento" name="complemento" value="${endereco.complemento}">
        </div>
        <button class="button-container" type="submit">Atualizar</button>
        <div>

      </form>




</body>

</html>
