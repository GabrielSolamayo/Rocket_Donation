document.addEventListener('DOMContentLoaded', function () {
    var form = document.querySelector('form');
    var submitMessage = document.getElementById('submitMessage');

    form.addEventListener('submit', function (event) {
        event.preventDefault(); // Evita o envio padrão do formulário

        // Lógica para processar o formulário pode ser adicionada aqui
        // Exemplo: enviar dados via AJAX para o servidor e exibir uma mensagem de confirmação

        // Exemplo de mensagem de confirmação
        submitMessage.innerHTML = '<p>Noticia publicada com sucesso! Obrigado por compartilhar.</p>';
    });
});