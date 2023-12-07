<%-- 
    Document   : cadastroDoErro
    Created on : 7 de dez. de 2023, 10:58:23
    Author     : solam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="cadastroDoa.css">
        <link href="https://cdn.jsdelivr.net/npm/remixicon@3.2.0/fonts/remixicon.css" rel="stylesheet">
        <title>Cadastro Doador Erro</title>


    </head>
    <body>

        <iframe src="menurocketdonation/menu.html"></iframe>

        <div class="content">

            <div id="sla">
                <div><h1>Cadastro</h1></div>
                <h1><i class="ri-user-add-line"></i></h1>
                <h1>Bem vindo de volta!</h1>
                <span>Se já possuir uma conta, faça login.</span>
                <button id="login-cad">
                    <a href="login.html" style="color: white; text-decoration: none;">Login</a>
                </button>
            </div>

            <div id="outraDiv">

                <form id="cadastrar-form" method="POST" action="Controller">
                    <input type="hidden" name="flag" value="cadastrarDoador">


                    <div class="input-row">
                        <label for="nome"> <p>Nome <i class="ri-user-3-line"></i></p></label>
                        <input type="text" id="nome" name="nome" placeholder="Digite Seu Nome" required>
                    </div>

                    <div class="input-row">
                        <label for="email"> <p>E-mail <i class="ri-mail-line"></i></p></label>
                        <input type="email" id="email" name="email" placeholder="ex@.com" required>
                    </div>

                    <div class="input-row">
                        <label for="telefone"><p>Telefone <i class="ri-phone-line"></i></p>  </label>
                        <input type="text" id="telefone" name="telefone" placeholder="(XX) XXXX-XXXX" required>
                    </div>

                    <div class="input-row">
                        <label for="numero"> <p>Número <i class="ri-home-4-line"></i></p></label>
                        <input type="text" id="numero" name="numero" placeholder="N°" required>
                    </div>

                    <div class="input-row">
                        <label for="rua"> <p>Endereço <i class="ri-home-4-line"></i> </p></label>
                        <input type="text" id="endereco" name="endereco" placeholder="Rua / Avenida" required>
                    </div>

                    <div class="input-row">
                        <label for="cep"><p>CEP <i class="ri-map-pin-line"></i></p></label>
                        <input type="text" id="cep" name="cep" placeholder="CEP" required>
                    </div>
                    <div class="input-row">
                        <label for="senha"> <p> Senha <i class="ri-lock-password-line"></i></p></label>
                        <input class="campo" type="password" id="senha" name="senha" placeholder="Senha "required>
                    </div>
                    <div class="input-row">
                        <label for="rua"><p>Complemento <i class="ri-home-4-line"></i></p> </label>
                        <input type="text" id="complemento" name="complemento" placeholder="Casa/Apartamento" required>
                    </div>
                    <div class="input-row">
                        <label for="confirmarSenha"><p> Confirme <i class="ri-pass-valid-line"></i></p></label>
                        <input class="campo" type="password" id="confirmarSenha" name="confirmarSenha" placeholder="Confirme sua senha" required>
                    </div>

                    <input type="submit" class="button-container" value="Cadastrar"> 
                    <h2 style="color: brown;">${m}</h2>

                </form>
            </div>

        </div>
    </body>
</html>