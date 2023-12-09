<%-- 
    Document   : testeJanela
    Created on : 8 de dez. de 2023, 16:18:54
    Author     : solam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html >
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/login.css">
    </head>
    <body> 
        <header style="padding-top: 100px">
        <%@ include file="menuu.jsp"%>
        </header>
           
    <div class="content">
       
        <div id="sla">
            <h1>Login</h1>
           <h1> <i class="ri-user-line"></i></h1> 
            <h1>Bem vindo de volta!</h1>
            <span>Caso não possua uma conta, crie uma agora</span>
            <button id="login-cad"><a href="cadastroDoa.jsp">Cadastre-se</a></button>
        </div>
        <div id="outraDiv">
            <h1></h1>
            <form id="cadastrar-form" method="POST" action="controle">
                <input type="hidden" name="flag" value="login">
                  <div class="input-row">
                    <label for="email">Email <i class="ri-mail-line"></i></label>
                    <input type="text" id="email" placeholder="Email" name="email" size="70" required>
                  </div>
                  <div class="input-row">
                    <label for="senha">Senha <i class="ri-lock-password-line"></i></label>
                    <input class="campo" type="password" id="senha" placeholder="Senha" name="senha" size="30" style="padding: 5px 0px;" required>
                  </div>
                  <div class="button-container">
                        <input type="submit" value="Login">
                  </div>  
            </form>
        </div>

    </div>
      
    </body>
</html>
