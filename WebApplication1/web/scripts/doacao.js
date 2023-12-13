function generateRandomNumber() {
    return Math.floor(Math.random() * 1000000);
}

function generateQRCode() {
    const randomNumber = generateRandomNumber();
    const randomString = randomNumber.toString();

    // Remove a div existente
    const existingDiv = document.getElementById("qrcode");
    existingDiv.parentNode.removeChild(existingDiv);

    // Cria uma nova div para o QR code
    const newDiv = document.createElement("div");
    newDiv.id = "qrcode";
    document.getElementById("qrcode-container").appendChild(newDiv);

    // Cria um objeto QRCode
    const qrcode = new QRCode(newDiv, {
        text: randomString,
        width: 128,
        height: 128
    });

    // Exibe o número aleatório
    console.log("Número Aleatório:", randomNumber);
}

// Gera um código QR inicial
generateQRCode();

// Adiciona um evento de clique ao botão para gerar um novo código
document.getElementById("generateButton").addEventListener("click", generateQRCode);
