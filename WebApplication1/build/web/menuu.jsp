<%-- 
    Document   : menuu
    Created on : 8 de dez. de 2023, 14:56:32
    Author     : solam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <!--=============== REMIXICONS ===============-->
        <link href="https://cdn.jsdelivr.net/npm/remixicon@3.2.0/fonts/remixicon.css" rel="stylesheet">


        <!--=============== CSS ===============-->
        <link rel="stylesheet" href="./css/stylesMenu.css">

        <title>Menu Componente</title>
    </head>

    <body>
        <!--=============== HEADER ===============-->
        <section id="home">
            <header class="header">

                <nav class="nav container">
                    <div class="nav__data">
                        <a href="#">
                            <!-- <i class="ri-planet-line"></i> Company-->

                            <img src="./pictures/Rocket_Donatiton.png" alt="Logo">


                        </a>

                        <div class="nav__toggle" id="nav-toggle">
                            <i class="ri-menu-line nav__burger"></i>
                            <i class="ri-close-line nav__close"></i>
                        </div>
                    </div>

                    <!--=============== NAV MENU ===============-->
                    <div class="nav__menu" id="nav-menu">
                        <ul class="nav__list">
                            <li><a  href="./index.jsp#Home" class="nav__link"><i class="ri-home-2-line"></i>Home</a></li>

                            <li><a href="./index.jsp#Organização" class="nav__link"><i class="ri-home-heart-line"></i>Organizações</a></li>


                            <li><a href="./index.jsp#Noticia" class="nav__link"><i class="ri-slideshow-line"></i>Noticias</a></li>

                            <!--=============== DROPDOWN 1 ===============-->

                            <ul class="dropdown__menu">


                                <!--=============== DROPDOWN SUBMENU ===============-->
                                <li class="dropdown__subitem">
                                    <div class="dropdown__link">
                                        <i class="ri-bar-chart-line"></i> Reports <i class="ri-add-line dropdown__add"></i>
                                    </div>

                                    <ul class="dropdown__submenu">
                                        <li>
                                            <a href="#" class="dropdown__sublink">
                                                <i class="ri-file-list-line"></i> Documents
                                            </a>
                                        </li>

                                        <li>
                                            <a href="#" class="dropdown__sublink">
                                                <i class="ri-refund-2-line"></i> Refunds
                                            </a>
                                        </li>
                                    </ul>
                                </li>
                            </ul>
                            </li>

                            <li><a href="index.jsp#Sobre" class="nav__link"><i class="ri-heart-add-line"></i>Sobre</a></li>

                            <!--=============== DROPDOWN 2 ===============-->
                            <li class="dropdown__item">
                                <div class="nav__link">
                                    <i class="ri-login-circle-line"></i>Cadastre-se <i
                                        class="ri-arrow-down-s-line dropdown__arrow"></i>
                                </div>

                                <ul class="dropdown__menu">


                                    <li>
                                        <a href="cadastroDoa.jsp" class="dropdown__link">
                                            <i class="ri-user-heart-line"></i> Doador
                                        </a>
                                    </li>

                                    <li>
                                        <a href="cadastroOrg.jsp" class="dropdown__link">
                                            <i class="ri-home-heart-line"></i> Organização
                                        </a>
                                    </li>
                                </ul>
                            </li>


                        </ul>
                    </div>
                </nav>
            </header>
            <!--=============== MAIN JS ===============-->
            <script src="js/menuScript.js"></script>
    </body>

</html>
