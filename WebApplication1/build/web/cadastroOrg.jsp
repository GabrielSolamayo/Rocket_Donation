<!DOCTYPE html>
<html lang="pt-br">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Cadastro de Organização</title>
  <link rel="stylesheet" href="css/cadastroOrg.css">
  <link href="https://cdn.jsdelivr.net/npm/remixicon@3.2.0/fonts/remixicon.css" rel="stylesheet">

</head>

<body>
  <header style="padding-top: 100px">
    <%@ include file="menuu.jsp" %>
  </header>

  <div class="content">

    <div id="sla">
      <div>
        <h1>Cadastro Organizacao</h1>
      </div>
      <h1><i class="ri-home-heart-line"></i></h1>
      <h1>Bem vindo de volta!</h1>

      <span>Se já possuir uma conta, faça login.</span>
      <button id="login-cad"><a href="login.jsp">Login</a></button>
    </div>
    <div id="outraDiv">
      <!-- <h1>Cadastre-se</h1> -->
      <form id="cadastrar-form" method="POST" action="controle">
        <input type="hidden" name="flag" value="cadastroOrg">
        <div class="input-row">
          <label for="nomeOrg">Nome da Organizacao <i class="ri-home-heart-line"></i></label>
          <input type="text" id="nomeOrg" name="nomeOrg" placeholder="Nome da Organizacao" required>
        </div>
        
        <div class="input-row">
          <label for="site">Site <i class="ri-global-line"></i></label>
          <input type="text" id="site" name="site" placeholder="www.ex@.com" required>
        </div>
        <div class="input-row">
          <label for="emailOrg">E-mail <i class="ri-mail-line"></i></label>
          <input type="email" id="emailOrg" name="emailOrg" placeholder="exemplo@exem.com" required>
        </div>
        
        <div class="input-row">
          <label for="categoria">Categoria da organizacao</label>
          <select id="categoria" name="categoria" required>
            <option value="" disabled selected hidden>Escolha uma opcao</option>
            <option value="cultura">Cultura</option>
            <option value="racismo">Anti-Racismo</option>
            <option value="meioAmbiente">Meio Ambiente</option>
            <option value="educacao">Educacao</option>
            <option value="saude">Saude</option>
            <!-- Adicione outras opcoes aqui -->
          </select>
        </div>
        <div class="input-row">
          <label for="urlFotoLocal">Foto do Local <i class="ri-image-line"></i></label>
          <input type="url" id="urlFotoLocal" name="urlFotoLocal" placeholder="URL da Foto do Local" required>
      </div>
      <div class="input-row">
        <label for="telefone">Telefone <i class="ri-phone-line"></i></label>
        <input type="text" id="telefone" name="telefone" placeholder="(XX) XXXX-XXXX" required>
      </div>
      <div class="input-row">
        <label for="urlFotoLocal">Foto de Perfil <i class="ri-image-line"></i></label>
        <input type="url" id="urlFotoLocal" name="urlFotoPerfil" placeholder="URL da Foto do Local" required>
    </div>
    <div class="input-row">
      <label for="cep">CEP <i class="ri-map-pin-line"></i></label>
      <input type="text" id="cep" name="cep" placeholder="CEP" required>
    </div>
        <div class="input-row">
          <label for="senha">
            <p> Senha <i class="ri-lock-password-line"></i></p>
          </label>
          <input class="campo" type="password" id="senha" name="senha" placeholder="Senha" required>
        </div>
        <div class="input-row">
          <label for="agenciaConta">Agencia <i class="ri-bank-line"></i></label>
          <input type="text" id="agenciaConta" name="agenciaConta" placeholder="Agencia" required>
        </div>
        <div class="input-row">
          <label for="confirmarSenha">
            <p> Confirme <i class="ri-pass-valid-line"></i></p>
          </label>
          <input class="campo" type="password" id="confirmarSenha" name="confirmarSenha"
            placeholder="Confirme sua senha" required>
        </div>
        
        <div class="input-row">
          <label for="site">Descricao breve do Organizacao <i class=""></i></label>
          <input type="text" id="site" name="descOrg" placeholder="Esta organizacao..." required>
        </div>
        <div class="input-row">
          <label for="numeroConta">Conta Bancaria <i class="ri-bank-line"></i></label>
          <input type="text" id="numeroConta" name="numeroConta" placeholder="Conta" required>
        </div>
        <div class="input-row">
          <label for="rua">Endereco <i class="ri-home-4-line"></i> </label>
          <input type="text" id="rua" name="rua" placeholder="Rua / Avenida" required>
        </div>
        <div class="input-row">
          <label for="chavePix">Chave PIX <i class="ri-qr-code-line"></i></label>
          <input type="text" id="chavePix" name="chavePix" placeholder="PIX" required>
        </div>
        <div class="input-row">
          <label for="numero">Numero <i class="ri-home-4-line"></i> </label>
          <input type="text" id="numero" name="numero" placeholder="Num" required>
        </div>
        <div class="input-row">
          <label for="numeroConta">Codigo do Banco <i class="ri-bank-line"></i></label>
          <input type="text" id="numeroConta" name="codBanco" placeholder="Cod " required maxlength="3">
        </div>
        <div class="input-row">
          <label for="missao">Missão da Organizacao <i class="ri-home-heart-line"></i></label>
          <textarea id="missao" name="missao" required></textarea>
        </div>
        <div class="input-row">
          <label for="complemento">Complemento <i class="ri-home-4-line"></i> </label>
          <input type="text" id="complemento" name="complemento" placeholder="Casa/Predio">
        </div>
        <button class="button-container" id="botaoCad" type="submit" onclick="minhaFuncao()">Cadastrar</button>
        <div>

      </form>
    </div>




</body>

</html>
