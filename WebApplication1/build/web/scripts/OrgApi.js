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
                imagem.textContent = instituicao.img;
                imagem.src = `${imagem.textContent}`; // Substitua com o caminho da sua imagem
                imagem.alt = 'Foto do perfil da instituição';

                var nome = document.createElement('h2');
                nome.textContent = instituicao.nome;

                var missao = document.createElement('p');
                missao.classList.add('mission'); // Adicionando uma classe para identificação
                var missaoText = instituicao.missao;

                if (missaoText.length > 150) {
                    missao.textContent = missaoText.substring(0, 150) + '...';
                } else {
                    missao.textContent = missaoText;
                }

                var button = document.createElement('button');
                button.classList.add('button__card');

                var link = document.createElement('a');
                link.href = instituicao.linkDoacao;
                link.innerHTML = '<i class="ri-hand-heart-line"></i>Doar';

                link.addEventListener('click', function (event) {
                    event.preventDefault()
                    var instituicaoId = instituicao.id; // Supondo que 'id' é o nome do atributo que contém o ID da instituição
                    window.location.href = 'controle?flag=orgSelecionado&email=' + instituicaoId; // Redireciona para a página TelaPerfil.jsp com o ID da instituição
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