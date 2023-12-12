function initializeSlider(sliderSelector, prevButtonSelector, nextButtonSelector, cardSelector) {
    const slider = document.querySelector(sliderSelector);
    const prevButton = document.querySelector(prevButtonSelector);
    const nextButton = document.querySelector(nextButtonSelector);
    let cards = document.querySelectorAll(cardSelector);
    let currentIndex = 0;

    function nextSlide() {
        cards = document.querySelectorAll(cardSelector); // Atualiza a lista de cards
        currentIndex = (currentIndex + 1) % cards.length;
        updateSlider();
    }

    function previousSlide() {
        cards = document.querySelectorAll(cardSelector); // Atualiza a lista de cards
        currentIndex = (currentIndex - 1 + cards.length) % cards.length;
        updateSlider();
    }

    function updateSlider() {
        const translateX = currentIndex * -cards[0].offsetWidth;
        slider.style.transform = `translateX(${translateX}px)`;
    }

    nextButton.addEventListener("click", nextSlide);
    prevButton.addEventListener("click", previousSlide);

    updateSlider();
}

function carregarInstituicoes() {
    fetch('http://localhost:8080/WebApplication1/OrgApi')
            .then(function (response) {
                if (!response.ok) {
                    throw new Error('Erro ao fazer a requisição');
                }
                return response.json();
            })
            .then(function (data) {
                var instituicoesContainer = document.querySelector('.slider.slider-1');
                instituicoesContainer.innerHTML = ''; // Limpa o conteúdo atual do slider

                data.forEach(function (instituicao) {
                    var card = document.createElement('div');
                    card.classList.add('card__institute');

                    var imagem = document.createElement('img');
                    imagem.src = "./pictures/santos.png"; // Substitua com o caminho da sua imagem
                    imagem.alt = 'Foto do perfil da instituição';

                    var nome = document.createElement('h2');
                    nome.textContent = instituicao.nome;

                    var missao = document.createElement('p');
                    missao.textContent = instituicao.missao;

                    var button = document.createElement('button');
                    button.classList.add('button__card');

                    var link = document.createElement('a');
                    link.href = instituicao.linkDoacao;
                    link.innerHTML = '<i class="ri-hand-heart-line"></i>Doar';

                    link.addEventListener('click', function (event) {
                        event.preventDefault()
                        var instituicaoId = instituicao.id; // Supondo que 'id' é o nome do atributo que contém o ID da instituição
                        window.location.href = 'TelaPerfil.jsp?id=' + instituicaoId; // Redireciona para a página TelaPerfil.jsp com o ID da instituição
                    });

                    button.appendChild(link);

                    card.appendChild(imagem);
                    card.appendChild(nome);
                    card.appendChild(missao);
                    card.appendChild(button);

                    instituicoesContainer.appendChild(card);
                });

                // Re-inicializa o slider com os novos cards
                initializeSlider(".slider-1", ".prev-button-1", ".next-button-1", ".card__institute");
            })
            .catch(function (error) {
                console.error('Erro ao fazer a requisição:', error);
            });
}

carregarInstituicoes(); // Chama a função para carregar as instituições imediatamente