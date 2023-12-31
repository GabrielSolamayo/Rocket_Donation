<%-- 
    Document   : cadastroDoaERRO
    Created on : 9 de dez. de 2023, 07:50:43
    Author     : solam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/cadastroDoa.css">
    <link href="https://cdn.jsdelivr.net/npm/remixicon@3.2.0/fonts/remixicon.css" rel="stylesheet">
    <title>Cadastro Doador</title>


</head>

<body>

    <header style="padding-top: 100px">
        <%@ include file="menuu.jsp" %>
    </header>

    <div class="content">

        <div id="sla">
            <div>
                <h1>Cadastro</h1>
            </div>
            <h1><i class="ri-user-add-line"></i></h1>
            <h1>Bem vindo de volta!</h1>
            <span>Se jï¿½ possuir uma conta, faï¿½a login.</span>
            <button id="login-cad"><a href="login.jsp">Login</a></button>
        </div>

        <div id="outraDiv">

            <form id="cadastrar-form" method="POST" action="controle">
                <input type="hidden" name="flag" value="cadastroDoador">

                <div class="input-row">
                    <label for="nome">
                        <p>Nome <i class="ri-user-3-line"></i></p>
                    </label>
                    <input type="text" id="nome" name="nome" placeholder="Digite Seu Nome" required>
                </div>

                <div class="input-row">
                    <label for="email">
                        <p>E-mail <i class="ri-mail-line"></i></p>
                    </label>
                    <input type="email" id="email" name="email" placeholder="ex@.com" required>
                </div>

                <div class="input-row">
                    <label for="telefone">
                        <p>Telefone <i class="ri-phone-line"></i></p>
                    </label>
                    <input type="text" id="telefone" name="telefone" placeholder="(XX) XXXX-XXXX" required>
                </div>



                <div class="input-row">
                    <label for="numero">
                        <p>Nï¿½mero <i class="ri-home-4-line"></i></p>
                    </label>
                    <input type="text" id="numero" name="numero" placeholder="Nï¿½" required>
                </div>

                <div class="input-row">
                    <label for="rua">
                        <p>Endereï¿½o <i class="ri-home-4-line"></i> </p>
                    </label>
                    <input type="text" id="Endereï¿½o" name="Endereï¿½o" placeholder="Rua / Avenida" required>
                </div>

                <div class="input-row">
                    <label for="cep">
                        <p>CEP <i class="ri-map-pin-line"></i></p>
                    </label>
                    <input type="text" id="cep" name="cep" placeholder="CEP" required>
                </div>

                <div class="input-row">

                    <label for="senha">
                        <p> Senha <i class="ri-lock-password-line"></i></p>
                    </label>

                    <input class="campo" type="password" id="senha" name="senha" placeholder="Senha " required>

                </div>
                <div class="input-row">
                    <label for="rua">
                        <p>Complemento <i class="ri-home-4-line"></i></p>
                    </label>
                    <input type="text" id="Complemento" name="Complemento" placeholder="Casa/Apartamento" required>
                </div>

                <div class="input-row">
                    <label for="confirmarSenha">
                        <p> Confirme <i class="ri-pass-valid-line"></i></p>
                    </label>
                    <input class="campo" type="password" id="confirmarSenha" name="confirmarSenha"
                        placeholder="Confirme sua senha" required>
                </div>
                <p>${m}</p>


                <button class="button-container" type="submit">Cadastrar</button>


            </form>
        </div>

    </div>


</body>

</html>
