const jsonServer = require('json-server');
const server = jsonServer.create();
const router = jsonServer.router('db.json');
const middlewares = jsonServer.defaults();

server.use(middlewares);
server.use(jsonServer.json());

// Rota de Login (O que o professor usa para pegar o Token)
server.post('/login', (req, res) => {
    const { user, password } = req.body;
    if (user === 'admin@admin.com' && password === '123456') {
        res.jsonp({
            accessToken: "token-fake-do-teh-12345" // Esse é o token que você vai usar
        });
    } else {
        res.status(401).jsonp({ error: "Erro de login" });
    }
});

// O resto das rotas (/musicas, /artistas) o json-server resolve sozinho
server.use(router);

server.listen(3000, () => {
    console.log('API do Serratec Music rodando em http://localhost:3000');
});