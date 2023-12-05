// document.getElementById('cadastrar-form').addEventListener('submit', function(event) {
//     event.preventDefault();

//     let orgData = {
//         nomeOrg: document.getElementById('nomeOrg').value,
//         emailOrg: document.getElementById('emailOrg').value,
//         site: document.getElementById('site').value,
//         categoria: document.getElementById('categoria').value,
//         cep: document.getElementById('cep').value,
//         rua: document.getElementById('rua').value,
//         numero: document.getElementById('numero').value,
//         complemento: document.getElementById('complemento').value,
//         zona: document.getElementById('zona').value,
//         agenciaConta: document.getElementById('agenciaConta').value,
//         numeroConta: document.getElementById('numeroConta').value,
//         chavePix: document.getElementById('chavePix').value,
//         telefone: document.getElementById('telefone').value,
//         missao: document.getElementById('missao').value
//     };

//     fetch('http://localhost:8080/organizacao', {
//         method: 'POST',
//         headers: {
//             'Content-Type': 'application/json'
//         },
//         body: JSON.stringify(orgData)
//     })
//     .then(response => response.json())
//     .then(data => console.log(data))
//     .catch((error) => {
//         console.error('Error:', error);
//     });
// });

const saveAPI = async (organizacao) => {
    try {

        const response = await fetch("http://localhost:8080/organizacao", {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(organizacao)
        })

        if (response.ok) {
            console.log('Funcionario cadastrado com sucesso.');
            const organizacao = await response.json();
           console.log(organizacao);

        } else if (response.status == 400) {
            const errors = await response.json();
            console.log('Falha ao cadastrar funcionario ', errors);
        } else {
            console.log('ocorreu um erro');
        }
    } catch (error) {
        console.error('Ocorreu um erro:', error.message());
    }
}


const form = document.getElementById('cadastrar-form');
form.addEventListener('submit', (event) => {
    event.preventDefault();

    let organizacao = {
                nome: document.getElementById('nome').value,
                email: document.getElementById('email').value,
                cep: document.getElementById('cep').value,
                rua: document.getElementById('rua').value,
                numero: document.getElementById('numero').value,
                complemento: document.getElementById('complemento').value,
                zona: document.getElementById('zona').value,          
                telefone: document.getElementById('telefone').value,
               
            };
    saveAPI(organizacao);

    function validarSenhas() {
        var senha = document.getElementById("senha").value;
        var confirmarSenha = document.getElementById("confirmarSenha").value;
      
        if (senha !== confirmarSenha) {
          alert("As senhas não conferem.");
          return false;
        }
      
        return true;
      }

});