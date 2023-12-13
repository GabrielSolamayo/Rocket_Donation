function formatDate(dateString) {
    const months = [
        "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"
    ];

    const parts = dateString.split(" ");
    const month = months.indexOf(parts[1]);
    const day = parseInt(parts[2]);
    const year = parseInt(parts[3]);
    const timeParts = parts[4].split(":");
    const hour = parseInt(timeParts[0]);
    const minute = parseInt(timeParts[1]);
    const second = parseInt(timeParts[2]);

    return new Date(year, month, day, hour, minute, second);
}

function carregarNoticias() {
    fetch('http://localhost:8080/WebApplication1/NoticiaApi')
            .then(function (response) {
                if (!response.ok) {
                    throw new Error('Erro ao fazer a requisição');
                }
                return response.json();
            })
            .then(function (data) {
                var noticiasContainer = document.querySelector('.slider.slider-2');
                noticiasContainer.innerHTML = '';

                data.forEach(function (noticia) {
                    var card = document.createElement('div');
                    card.classList.add('card__news');

                    var imagem = document.createElement('img');
                    imagem.src = noticia.imagem;
                    imagem.alt = 'Foto do perfil da instituição';

                    var titulo = document.createElement('h2');
                    titulo.textContent = noticia.titulo;

                    var descricao = document.createElement('p');
                    descricao.classList.add('descricao'); // Adicionando classe na descrição
                    var descricaoText = noticia.descricao;

                    if (descricaoText.length > 150) {
                        descricao.textContent = descricaoText.substring(0, 150) + '...';
                    } else {
                        descricao.textContent = descricaoText;
                    }

                    var dataNoticia = document.createElement('p');
                    dataNoticia.textContent = 'Pub ' + noticia.data; // Formatando a data

                    var button = document.createElement('button');
                    button.classList.add('button__card');

                    var link = document.createElement('a');
                    link.href = '#';
                    link.innerHTML = '<i class="ri-book-read-fill"></i>Leia';

                    button.appendChild(link);

                    card.appendChild(imagem);
                    card.appendChild(titulo);
                    card.appendChild(descricao);
                    card.appendChild(dataNoticia); // Adicionando a data ao card
                    card.appendChild(button);

                    noticiasContainer.appendChild(card);
                });

                initializeSlider(".slider-2", ".prev-button-2", ".next-button-2", ".card__news");
            })
            .catch(function (error) {
                console.error('Erro ao fazer a requisição:', error);
            });
}

carregarNoticias();