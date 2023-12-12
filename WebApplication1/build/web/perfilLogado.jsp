<!DOCTYPE html>
<html lang="pt-br">

<head>
   <meta charset="UTF-8">
   <meta name="viewport" content="width=device-width, initial-scale=1.0">

   <!--=============== REMIXICONS ===============-->
   <link href="https://cdn.jsdelivr.net/npm/remixicon@3.2.0/fonts/remixicon.css" rel="stylesheet">

   <!--=============== CSS ===============-->
   <link rel="stylesheet" href="./css/TelaPefil.css">

   <title>Tela Perfil</title>
</head>

<body>
  <!--MENU Include-->
  
        <header style="padding-top: 100px">
            <%@ include file="menuLogado.jsp" %>
        </header>
  
      <div class="container_perfil">
         <div class="perfil">
            <div class="elementos">
            <div class="perfil_org">
            <img src="${doador.imagemUrl}" alt="">
            <h2>${doador.nome}</h2>
            <div class="opcoes_perfil">
               <a href="controle?flag=editarPerfilOrg&email=${doador.email}&enderecoID=${endereco.idendereco}"><button class="botao_perfil"><i class="ri-edit-2-line"></i>Editar Perfil</button></a>
               <a href="controle?flag=historico&email=${doador.email}"><button class="botao_perfil"><i class="ri-phone-find-fill"></i>Ver Hist�rico</button></a>
               <button class="botao_perfil"><i class="ri-draft-fill"></i>Publicar Noticia</button>
           </div>
         </div>
         <div class="perfil_sec">
            <img src="${doador.organizacao.localImagem}" alt="">
        </div>
        <div class="org_inf">
         <h2><i class="ri-phone-fill"></i>${doador.telefone}</h2>
         <h2><i class="ri-mail-open-line"></i>${doador.email}</h2>
         <h2><i class="ri-map-pin-line"></i>${endereco.rua}</h2>
         <h2><i class="ri-global-fill"></i>${doador.organizacao.site}</h2>
         <h2><i class="ri-timer-2-line"></i>Seg a Sex:8h as 17hrs</h2>
       </div>
      </div>
  
         </div><!--perfil-->
         <div class="missao">
          <h1><i class="ri-hearts-fill"></i>Miss�o</h1>
         <div class="background">
         <div class="container-missao">
         <div class="missao-org">
          <p>${doador.organizacao.missao}</p>
         </div><!--missao-->
        </div><!--missao-->
      </div><!--Background-->
    </div>
                       <!-- Card de Doa��o -->
    <div class="donate-card">
      <div class="card_donat">

      
      <h2>Fa�a sua doa��o</h2>
      <p>Ajude-nos a continuar nosso trabalho</p>
      <button class="donate-button">
          <a href="#" ><i class="ri-heart-fill"></i>Doar</a>
      </button>
   </div>
  </div>
         <div class="slider-container">
            <h1 class="title_not">Not�cias</h1>
            <div class="slider-buttons">
                <button class="prev-button prev-button-2"><i class="ri-arrow-left-line"></i></button>
                <button class="next-button next-button-2"><i class="ri-arrow-right-line"></i></button>
            </div>
            <div class="slider slider-2">
         
                <!-- Conte�do do segundo slider (Not�cias) -->
                <div class="card__news card__news-2" >
                    <img src="pictures/santos.png" alt="Institui��o 1">
                    <h2>Noticia 1</h2>
                    <p>Lorem ipsum dolor, sit amet consectetur adipisicing elit. Rem autem perspiciatis porro? Quia distinctio aliquam inventore, corrupti facere eos non similique soluta voluptatem aut, earum sapiente nostrum veritatis natus nisi.</p>
                    <button class="button__card">
                        <a href="#noticia_card1" ><i class="ri-book-read-fill"></i>Leia</a>
                    </button>
                    <!-- Conte�do da not�cia 1 -->
                </div>
                <div class="card__news card__news-2">
                    <img src="pictures/santos.png" alt="Institui��o 1">
                    <h2>Noticia 2</h2>
                    <p>Lorem ipsum dolor sit amet consectetur, adipisicing elit. Quod amet non eum facere aliquid laboriosam molestiae ea odit, repudiandae exercitationem. Officiis voluptatem, eligendi repudiandae fugiat nobis quasi! Iusto, eos quibusdam.</p>
                  <button class="button__card">
                    <a href="#noticia_card2" ><i class="ri-book-read-fill"></i>Leia</a>
                </button>
                    <!-- Conte�do da not�cia 2 -->
                </div>
                <div class="card__news card__news-2">
                  <img src="pictures/solidariedade.png" alt="Institui��o 1">
                  <h2>Noticia 3</h2>
                  <p>Lorem ipsum dolor sit amet consectetur, adipisicing elit. Quod amet non eum facere aliquid laboriosam molestiae ea odit, repudiandae exercitationem. Officiis voluptatem, eligendi repudiandae fugiat nobis quasi! Iusto, eos quibusdam.</p>
                <button class="button__card">
                  <a href="#noticia_card3" ><i class="ri-book-read-fill"></i>Leia</a>
              </button>
                  <!-- Conte�do da not�cia 2 -->
              </div>
     
                <!-- Adicione mais cards de not�cias aqui -->
         
            </div>

            
         </div><!-- Fim do segundo slider -->    
      </div><!--conatiner_perfil-->
      <div class="notice" >
      <section id="noticia_card1" class="noticia">
         <h2>T�tulo da Not�cia 1</h2>
         <p>Data da Publica��o: 10 de dezembro de 2023</p>
         
         <!-- Voc� pode adicionar uma imagem se a not�cia tiver uma -->
         <img src="pictures/Logo_oficial_-_MXS.png" alt="Descri��o da Imagem">
 
         <p>
             Lorem ipsum dolor sit amet, consectetur adipisicing elit. Iure, fugiat impedit hic atque praesentium maiores. Lorem ipsum dolor sit, amet consectetur adipisicing elit. Omnis ut mollitia quod deserunt atque? Rerum porro saepe nesciunt. Quas unde aspernatur voluptates animi? Rem tempora voluptatum, earum eaque sed tempore.  Vel placeat quaerat illum, sunt reiciendis cupiditate velit repellendus, accusantium laudantium hic odit, nostrum esse.
         </p>
     </section>
     <section id="noticia_card2" class="noticia" >
      <h2>T�tulo da Not�ci 2</h2>
      <p>Data da Publica��o: 10 de dezembro de 2023</p>
      
      <!-- Voc� pode adicionar uma imagem se a not�cia tiver uma -->
      <img src="pictures/Logo_oficial_-_MXS.png" alt="Descri��o da Imagem">

      <p>
          Lorem ipsum dolor sit amet, consectetur adipisicing elit. Iure, fugiat impedit hic atque praesentium maiores. Lorem ipsum dolor sit, amet consectetur adipisicing elit. Omnis ut mollitia quod deserunt atque? Rerum porro saepe nesciunt. Quas unde aspernatur voluptates animi? Rem tempora voluptatum, earum eaque sed tempore.  Vel placeat quaerat illum, sunt reiciendis cupiditate velit repellendus, accusantium laudantium hic odit, nostrum esse.
      </p>
  </section>
  <section id="noticia_card3" class="noticia" >
   <h2>T�tulo da Not�cia 3</h2>
   <p>Data da Publica��o: 10 de dezembro de 2023</p>
   
   <!-- Voc� pode adicionar uma imagem se a not�cia tiver uma -->
   <img src="pictures/Logo_oficial_-_MXS.png" alt="Descri��o da Imagem">

   <p>
       Lorem ipsum dolor sit amet, consectetur adipisicing elit. Iure, fugiat impedit hic atque praesentium maiores. Lorem ipsum dolor sit, amet consectetur adipisicing elit. Omnis ut mollitia quod deserunt atque? Rerum porro saepe nesciunt. Quas unde aspernatur voluptates animi? Rem tempora voluptatum, earum eaque sed tempore.  Vel placeat quaerat illum, sunt reiciendis cupiditate velit repellendus, accusantium laudantium hic odit, nostrum esse.
   </p>
</section>
     <!-- Adicione mais divs com a classe "noticia" para cada not�cia adicional -->
   
   </div><!--Notice-->
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
          <h3>Links R�pidos</h3>
          <ul>
            <li><a href="#home"><i class="ri-pages-line"></i> P�gina Inicial</a></li>
            <li><a href="#Sobre"><i class="ri-rocket-fill"></i> Sobre N�s</a></li>
            <li><a href="#Organiza��o"><i class="ri-home-heart-fill"></i> Organiza��es</a></li>
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
         <img src="pictures/Rocket_Donatiton.png" alt="Logo">
         <img src="pictures/mascote.png" alt="Mascote_Santos">
         <img src="pictures/ROCKT.png" alt="Logo_Empresa">
        <p>&copy; 2023 <i class="ri-rocket-2-fill"></i> Rocket Donatiton. Todos os direitos reservados.</p>
      </div>
    </footer>
     <!--=============== Carrossel ===============-->
   <script src="./scripts/carrosselPerfil.js"></script>
  
 
</body>

</html>