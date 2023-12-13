function realizarDoacao() {
    // Obtém o valor da doação do input
    const valorDoacao = document.getElementById('valorDoacao').value;
  
    // Verifica se o valor da doação é válido (pode adicionar mais validações conforme necessário)
    if (valorDoacao.trim() !== '') {
      // Aqui você pode adicionar lógica para enviar os dados, por exemplo, enviando para um servidor
      alert(`Doação de R$ ${valorDoacao} realizada com sucesso!`);
    } else {
      alert('Por favor, insira um valor válido.');
    }
  }