let formulario = {
    email : document.querySelector("#email"),
    senha : document.querySelector("#senha"),
    btnEntrar : document.querySelector("#btn-entrar"),
};
// Aqui estamos escutando o evento de click 
// js/login.js
const btnEntrar = document.getElementById('btn-entrar'); // Pegue o ID do seu botão Bootstrap

btnEntrar.addEventListener('click', async (e) => {
    e.preventDefault(); // Evita que a página recarregue

    // Aqui entra o código do Passo A que te mandei antes
    await realizarLogin();

    // Se o login deu certo, você redireciona:
    window.location.href = 'musicas.html';
});