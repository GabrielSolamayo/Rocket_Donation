function carregarInstituicoes() {
    fetch('http://localhost:8080/WebApplication1/OrgApi')
        .then(function(response) {
            if (!response.ok) {
                throw new Error('Erro ao fazer a requisição');
            }
            return response.json();
        })
        .then(function(data) {
            var instituicoesContainer = document.querySelector('.slider.slider-1');

            data.forEach(function(instituicao) {
                var card = document.createElement('div');
                card.classList.add('card__institute');

                var imagem = document.createElement('img');
                imagem.src = "./pictures/santos.png"; // Substitua com o caminho da sua imagem
                imagem.alt = 'Foto do perfil da instituição'; // Substitua 'nome' pelo nome do campo na resposta da API que contém o nome da instituição

                var nome = document.createElement('h2');
                nome.textContent = instituicao.nome; // Substitua 'nome' pelo nome do campo na resposta da API que contém o nome da instituição

                var missao = document.createElement('p');
                missao.textContent = instituicao.missao; // Substitua 'missao' pelo nome do campo na resposta da API que contém a missão da instituição

                var button = document.createElement('button');
                button.classList.add('button__card');

                var link = document.createElement('a');
                link.href = instituicao.linkDoacao; // Substitua 'linkDoacao' pelo nome do campo na resposta da API que contém o link de doação
                link.innerHTML = '<i class="ri-hand-heart-line"></i>Doar';

                button.appendChild(link);

                card.appendChild(imagem);
                card.appendChild(nome);
                card.appendChild(missao);
                card.appendChild(button);

                instituicoesContainer.appendChild(card);
            });
        })
        .catch(function(error) {
            console.error('Erro ao fazer a requisição:', error);
        });
}

document.addEventListener('DOMContentLoaded', carregarInstituicoes);