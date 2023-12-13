<%-- 
    Document   : home
    Created on : 8 de dez. de 2023, 15:05:11
    Author     : solam
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Rocket Donation</title>
        <link rel="stylesheet" href="./css/stylesIndex.css">
    </head>
    <body>



        <%@ include file="menuu.jsp"%>

        <section id="Home">
            <div class="background">
                <div class="outro">
                    <!--<div class="search-bar">
                 <input type="text" id="search" class="search-input" required>
                 <label for="search" class="search-label">Buscar Instituição...</label>
                 <button class="filtro"><i class="ri-equalizer-line"></i>Filtre</button>
             </div>-->
                    <div class="elements">
                        <div class="search-bar">
                            <input type="text" class="search-input" id="searchInput" placeholder="Pesquisar...">
                            <select class="filter-dropdown" id="categoryFilter">
                                <option value="Todas Categorias">Todas as Categorias</option>
                                <option value="Educação">Educação</option>
                                <option value="Saúde">Saúde</option>
                                <option value="Meio Ambiente">Meio Ambiente</option>
                            </select>


                        </div>

                        <button class="search-button" onclick="performSearch()"><i class="ri-search-2-line"></i></button>

                        <div class="donation-form">
                            <h2>Formas de Doação</h2>


                            <input type="checkbox" id="donation1" name="donation" value="Dinheiro">
                            <label for="donation1">Dinheiro</label>

                            <input type="checkbox" id="donation2" name="donation" value="Bens">
                            <label for="donation2">Bens</label>

                            <input type="checkbox" id="donation3" name="donation" value="Voluntariado">
                            <label for="donation3">Voluntariado</label>
                        </div>

                    </div><!--elements-->
                    <div class="container2">
                        <div class="card">
                            <img class="image" src="./pictures/solidariedade.png" alt="Imagem de exemplo">

                            <div class="content">
                                O Programa Sesc de Voluntariado vai aderir à campanha Dia de Doar, realizando ações
                                nas sete Unidades onde atua: Porto Alegre, Erechim, Ijuí, Santa Maria, Cachoeira do Sul, Rio Grande
                                e Lajeado. A mobilização internacional será no dia 30 de novembro e tem o objetivo de
                                estimular pessoas físicas, empresas e organizações a realizarem ações de solidariedade.
                            </div>

                            <div class="button-container">
                                <div class="button">
                                    <div class="button-text">Saiba Mais<i class="ri-chat-heart-line"></i></div>
                                </div>
                            </div>


                        </div>

                    </div>
                </div><!--outro-->
            </div><!--fundo-->
        </section><!--Home-->

        <section id="Organização">
            <!-- Primeiro Slider (Instituições) -->
            <div class="slider-container">
                <h1 class="title_Org"><i class="ri-home-heart-fill"></i>Organizações</h1>
                <div class="slider-buttons">
                    <button class="prev-button prev-button-1"><i class="ri-arrow-left-line"></i></button>
                    <button class="next-button next-button-1"><i class="ri-arrow-right-line"></i></button>
                </div>
                <div class="slider slider-1">


                </div>
            </div><!-- Fim do primeiro slider -->
        </section><!--organizações-->

        <section id="Noticia">
            <!-- Segundo Slider (Notícias) -->
            <div class="slider-container">
                <h1 class="title_not"><i class="ri-newspaper-fill"></i>Ultimas Notícias...</h1>
                <div class="slider-buttons">
                    <button class="prev-button prev-button-2"><i class="ri-arrow-left-line"></i></button>
                    <button class="next-button next-button-2"><i class="ri-arrow-right-line"></i></button>
                </div>
                <div class="slider slider-2">


                </div>
            </div>
        </div><!-- Fim do segundo slider -->    
    </section><!--section noticia-->

    <section id="Sobre">
        <div class="fundo_sobre">
            <div class="sobre_elementos">
                <div class="texto_sobre">
                    <img src="./pictures/ROCKT.png" alt="Imagem_EmpresaRocket">
                    <p>Na vanguarda da inovação, somos impulsionados por uma abordagem única para a filantropia. O Rocket
                        Donation não é apenas um site; é um portal para a transformação social. Com interfaces intuitivas,
                        segurança robusta e uma abordagem centrada no usuário, oferecemos uma experiência de doação sem igual.
                    </p>
                </div>
            </div><!--elements-->
        </div><!--Fundo_sobre-->

    </section>
    <footer>
        <div class="rodape-container">
            <div class="informacoes">
                <h3>Entre em Contato</h3>
                <p><i class="ri-mail-line"></i> Email: Rocket@gmail.com</p>
                <p><i class="ri-phone-line"></i> Telefone: (019)-4002-8922</p>
                <p><i class="ri-pin-distance-line"></i> Cidade: Santos</p>
                <p><i class="ri-building-line"></i> Bairro: Villa Belmiro</p>
            </div>

            <div class="links-rapidos">
                <h3>Links Rápidos</h3>
                <ul>
                    <li><a href="#home"><i class="ri-pages-line"></i> Página Inicial</a></li>
                    <li><a href="#Sobre"><i class="ri-rocket-fill"></i> Sobre Nós</a></li>
                    <li><a href="#Organização"><i class="ri-home-heart-fill"></i> Organizações</a></li>
                    <li><a href="#Noticia"><i class="ri-file-list-3-line"></i> Noticias</a></li>
                </ul>
            </div>

            <div class="redes-sociais">
                <h3>Siga-nos</h3>
                <ul>
                    <li><a href="#" target="_blank" rel="noopener noreferrer"><i class="ri-facebook-circle-fill"></i> Facebook</a></li>
                    <li><a href="#" target="_blank" rel="noopener noreferrer"><i class="ri-twitter-line"></i> Twitter</a></li>
                    <li><a href="#" target="_blank" rel="noopener noreferrer"><i class="ri-instagram-line"></i> Instagram</a></li>
                </ul>
            </div>
        </div>

        <div class="direitos">
            <img src="./pictures/Rocket_Donatiton.png" alt="Logo">
            <img src="./pictures/mascote.png" alt="Mascote_Santos">
            <img src="./pictures/ROCKT.png" alt="Logo_Empresa">
            <p>&copy; 2023 <i class="ri-rocket-2-fill"></i> Rocket Donatiton. Todos os direitos reservados.</p>
        </div>
    </footer>

<srcipt src="./scripts/indexScript.js"></script>
<script src="<c:url value="./scripts/menuScript.js" />"></script>
<script src="<c:url value="./scripts/indexScript.js" />"></script>
<script src="<c:url value="./scripts/OrgApi.js" />"></script>
<script src="<c:url value="./scripts/noticiaApi.js" />"></script>
</body>
</html>
